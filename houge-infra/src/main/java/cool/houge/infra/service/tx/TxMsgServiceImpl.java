package cool.houge.infra.service.tx;

import cool.houge.domain.model.UserMsg;
import cool.houge.domain.msg.UserMsgDao;
import cool.houge.infra.service.MsgServiceImpl;
import cool.houge.infra.tx.TxOps;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class TxMsgServiceImpl extends MsgServiceImpl {

  private final TxOps txOps;

  public @Inject TxMsgServiceImpl(TxOps txOps, UserMsgDao userMsgDao) {
    super(userMsgDao);
    this.txOps = txOps;
  }

  @Override
  public Mono<Void> insert(UserMsg msg) {
    return super.insert(msg).as(txOps::tx);
  }
}
