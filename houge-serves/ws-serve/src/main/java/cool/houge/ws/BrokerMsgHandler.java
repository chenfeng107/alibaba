package cool.houge.ws;

import cool.houge.grpc.BrokerMsg;
import cool.houge.protos.MsgKind;
import cool.houge.ws.packet.BaseMsgPacket;
import cool.houge.ws.packet.GroupMsgPacket;
import cool.houge.ws.packet.PrivateMsgPacket;
import cool.houge.ws.session.SessionGroupManager;
import cool.houge.ws.session.SessionManager;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/** @author KK (kzou227@qq.com) */
public class BrokerMsgHandler {

  private static final Logger log = LogManager.getLogger();
  private final SessionManager sessionManager;
  private final SessionGroupManager sessionGroupManager;

  public @Inject BrokerMsgHandler(
      SessionManager sessionManager, SessionGroupManager sessionGroupManager) {
    this.sessionManager = sessionManager;
    this.sessionGroupManager = sessionGroupManager;
  }

  /** @param msg */
  public void run(BrokerMsg msg) {
    this.handle(msg)
        .subscribeOn(Schedulers.boundedElastic())
        .doOnError(
            ex -> {
              // 记录错误日志
              log.error("处理消息失败 msg={}", msg, ex);
            })
        .subscribe();
  }

  /**
   * @param msg
   * @return
   */
  Mono<Void> handle(BrokerMsg msg) {
    var kind = msg.getKind();
    if (kind == MsgKind.USER) {
      return sessionManager
          .findByUid(msg.getTo())
          .flatMap(
              session -> {
                var packet = new PrivateMsgPacket();
                this.copyTo(msg, packet);
                return session.send(packet);
              })
          .then();
    } else if (kind == MsgKind.GROUP) {
      return sessionGroupManager
          .findByGroupId(msg.getTo())
          .flatMap(
              session -> {
                var packet = new GroupMsgPacket();
                this.copyTo(msg, packet);
                return session.send(packet);
              })
          .then();
    } else {
      log.error("未知的 MsgKind={}", kind);
      return Mono.empty();
    }
  }

  void copyTo(BrokerMsg msg, BaseMsgPacket packet) {
    packet
        .setMsgId(msg.getMsgId())
        .setFrom(msg.getFrom())
        .setTo(msg.getTo())
        .setContent(msg.getContent())
        .setContentType(msg.getContentTypeValue())
        .setExtra(msg.getExtra());
  }
}
