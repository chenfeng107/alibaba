package cool.houge.poplar.broker;

import cool.houge.grpc.BrokerMsg;

/** @author KK (kzou227@qq.com) */
public interface MsgRouter {

  /** @param msg */
  void run(BrokerMsg msg);
}
