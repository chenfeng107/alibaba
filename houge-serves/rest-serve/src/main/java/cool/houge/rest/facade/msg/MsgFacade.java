package cool.houge.rest.facade.msg;

import cool.houge.grpc.CreateMsgIdRequest;
import cool.houge.grpc.CreateMsgIdsRequest;
import cool.houge.grpc.ReactorMsgGrpc.ReactorMsgStub;
import cool.houge.grpc.SendMsgRequest;
import cool.houge.protos.MsgContentType;
import cool.houge.protos.MsgKind;
import cool.houge.rest.auth.AuthContext;
import java.util.List;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/**
 * 消息.
 *
 * @author KK (kzou227@qq.com)
 */
public class MsgFacade {

  private final ReactorMsgStub msgStub;

  public @Inject MsgFacade(ReactorMsgStub msgStub) {
    this.msgStub = msgStub;
  }

  /**
   * 得到消息ID.
   *
   * @return 消息ID
   */
  public Mono<String> fetchMsgId() {
    return msgStub
        .createId(CreateMsgIdRequest.getDefaultInstance())
        .map(
            resp -> {
              var id = resp.getMsgId();
              if (id.isEmpty()) {
                // FIXME 优化异常
                throw new RuntimeException("未成功获取到消息ID");
              }
              return id;
            });
  }

  /**
   * @param count
   * @return
   */
  public Mono<List<String>> fetchMsgIds(int count) {
    var req = CreateMsgIdsRequest.newBuilder().setCount(count).build();
    return msgStub.createIds(req).map(resp -> resp.getMsgIdList());
  }

  /**
   * @param input
   * @return
   */
  public Mono<SendMsgOutput> send(AuthContext ac, SendMsgInput input) {
    var kind = MsgKind.forNumber(input.getKind());

    var contentType = MsgContentType.forNumber(input.getContentType());
    var builder = SendMsgRequest.newBuilder();
    builder
        .setFrom(ac.uid())
        .setTo(input.getTo())
        .setContent(input.getContent())
        .setContentType(contentType);
    if (input.getExtra() != null) {
      builder.setExtra(input.getExtra());
    }

    return fetchMsgId()
        .flatMap(
            msgId -> {
              builder.setMsgId(msgId);

              var rv = new SendMsgOutput().setMsgId(msgId);
              if (kind == MsgKind.USER) {
                return msgStub.sendToUser(builder.build()).thenReturn(rv);
              }
              return msgStub.sendToGroup(builder.build()).thenReturn(rv);
            });
  }
}
