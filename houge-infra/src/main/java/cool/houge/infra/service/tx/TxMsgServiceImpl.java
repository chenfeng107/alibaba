package cool.houge.infra.service.tx;

import cool.houge.domain.model.Msg;
import cool.houge.domain.msg.MsgDao;
import cool.houge.infra.service.MsgServiceImpl;
import cool.houge.infra.tx.TxOps;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class TxMsgServiceImpl extends MsgServiceImpl {

  private final TxOps txOps;

  public @Inject TxMsgServiceImpl(TxOps txOps, MsgDao msgDao) {
    super(msgDao);
    this.txOps = txOps;
  }

  @Override
  public Mono<Void> insert(Msg msg) {
    return txOps.tx(Mono.defer(() -> super.insert(msg)));
  }
}
