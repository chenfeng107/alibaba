package cool.houge.ws;

import cool.houge.grpc.AuthRequest;
import cool.houge.grpc.ReactorAuthGrpc.ReactorAuthStub;
import cool.houge.grpc.ReactorMsgGrpc.ReactorMsgStub;
import cool.houge.grpc.SendMsgRequest;
import cool.houge.grpc.SendMsgResponse;
import cool.houge.protos.MsgContentType;
import cool.houge.ws.packet.MsgPacket;
import cool.houge.ws.packet.PrivateMsgPacket;
import cool.houge.ws.session.Session;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class LibService {

  private final ReactorAuthStub authStub;
  private final ReactorMsgStub msgStub;

  public LibService(ReactorAuthStub authStub, ReactorMsgStub msgStub) {
    this.authStub = authStub;
    this.msgStub = msgStub;
  }

  /**
   * @param token
   * @return
   */
  public Mono<Integer> auth(String token) {
    var req = AuthRequest.newBuilder().setToken(token).build();
    return authStub.auth(req).map(resp -> resp.getUid());
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
