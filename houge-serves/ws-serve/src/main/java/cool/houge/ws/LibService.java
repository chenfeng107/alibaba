package cool.houge.ws;

import com.google.common.base.Strings;
import cool.houge.grpc.CreateMsgIdRequest;
import cool.houge.grpc.ReactorMsgGrpc.ReactorMsgStub;
import cool.houge.grpc.ReactorTokenGrpc.ReactorTokenStub;
import cool.houge.grpc.SendMsgRequest;
import cool.houge.grpc.VerifyTokenRequest;
import cool.houge.protos.MsgContentType;
import cool.houge.ws.packet.ErrorPacket;
import cool.houge.ws.packet.MsgPacket;
import cool.houge.ws.packet.PrivateMsgPacket;
import cool.houge.ws.session.Session;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class LibService {

  private static final Logger log = LogManager.getLogger();
  private final ReactorTokenStub tokenStub;
  private final ReactorMsgStub msgStub;

  public @Inject LibService(ReactorTokenStub tokenStub, ReactorMsgStub msgStub) {
    this.tokenStub = tokenStub;
    this.msgStub = msgStub;
  }

  /**
   * @param token
   * @return
   */
  public Mono<Integer> auth(String token) {
    var req = VerifyTokenRequest.newBuilder().setToken(token).build();
    return tokenStub.verify(req).map(resp -> resp.getUid());
  }

  /**
   * @param session
   * @param p
   * @return
   */
  public Mono<Void> perform(Session session, MsgPacket p) {
    var contentType = MsgContentType.forNumber(p.getContentType());
    if (contentType == MsgContentType.UNRECOGNIZED) {
      var msg = Strings.lenientFormat("消息包中包含不认识的内容类型 content_type=%s", p.getContentType());
      log.warn(msg);
      // FIXME 定义错误码
      var ep = ErrorPacket.builder().code(-1).message(msg).build();
      return session.send(ep);
    }

    var requestMono =
        Mono.justOrEmpty(p.getMsgId())
            // 请求中不包含消息ID时自动从逻辑服务中生成
            .switchIfEmpty(
                Mono.defer(
                    () -> {
                      var req = CreateMsgIdRequest.newBuilder().build();
                      return msgStub
                          .createId(req)
                          .map(resp -> resp.getMsgId())
                          .doOnNext(msgId -> log.debug("自动创建消息ID {}", msgId));
                    }))
            .map(
                msgId -> {
                  var builder = SendMsgRequest.newBuilder();
                  builder
                      .setFrom(p.getFrom() == null ? session.uid() : p.getFrom())
                      .setTo(p.getTo())
                      .setContent(p.getContent())
                      .setContentType(contentType);
                  if (p.getExtra() != null) {
                    builder.setExtra(p.getExtra());
                  }
                  return builder.build();
                });

    if (p instanceof PrivateMsgPacket) {
      return msgStub
          .sendToUser(requestMono)
          .doOnSuccess(
              (resp) -> {
                // 记录日志
                log.debug("私聊消息已经成功发送至逻辑服务 {}", resp.getMsgId());
              })
          .then();
    } else {
      return msgStub
          .sendToGroup(requestMono)
          .doOnSuccess(
              (resp) -> {
                // 记录日志
                log.debug("群聊消息已经成功发送至逻辑服务 {}", resp.getMsgId());
              })
          .then();
    }
  }
}
