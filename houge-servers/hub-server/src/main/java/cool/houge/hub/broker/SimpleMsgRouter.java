package cool.houge.hub.broker;

import cool.houge.grpc.AttachBrokerResponse;
import cool.houge.grpc.BrokerMsg;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** @author KK (kzou227@qq.com) */
public class SimpleMsgRouter implements MsgRouter {

  private static final Logger log = LogManager.getLogger();
  private final BrokerManager brokerManager;

  public @Inject SimpleMsgRouter(BrokerManager brokerManager) {
    this.brokerManager = brokerManager;
  }

  @Override
  public void run(BrokerMsg msg) {
    var resp = AttachBrokerResponse.newBuilder().setMsg(msg).build();
    brokerManager
        .all()
        .doOnNext(
            sink -> {
              var rs = sink.tryEmitNext(resp);
              if (rs.isFailure()) {
                log.info("消息路由失败 msg={}", msg);
              }
            })
        .doOnError(
            ex -> {
              //
              log.info("消息路由异常", ex);
            })
        .subscribe();
  }
}
