package cool.houge.ws;

import cool.houge.grpc.ReactorMsgGrpc.ReactorMsgStub;
import cool.houge.grpc.ReactorTokenGrpc.ReactorTokenStub;
import cool.houge.grpc.SendMsgRequest;
import cool.houge.grpc.SendMsgResponse;
import cool.houge.grpc.VerifyTokenRequest;
import cool.houge.protos.MsgContentType;
import cool.houge.ws.packet.MsgPacket;
import cool.houge.ws.packet.PrivateMsgPacket;
import cool.houge.ws.session.Session;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class LibService {

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
  public Mono<Void> processMsgPacket(Session session, MsgPacket p) {
    var contentType = MsgContentType.forNumber(p.getContentType());
    // FIXME 校验 content-type

    var builder = SendMsgRequest.newBuilder();
    builder
        .setFrom(p.getFrom() == null ? session.uid() : p.getFrom())
        .setTo(p.getTo())
        .setContent(p.getContent())
        .setContentType(contentType);
    if (p.getExtra() != null) {
      builder.setExtra(p.getExtra());
    }

    Mono<SendMsgResponse> m;
    if (p instanceof PrivateMsgPacket) {
      m = msgStub.sendToUser(builder.build());
    } else {
      m = msgStub.sendToGroup(builder.build());
    }
    // FIXME
    return m.then();
  }
}
