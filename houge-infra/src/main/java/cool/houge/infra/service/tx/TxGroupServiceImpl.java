package cool.houge.infra.service.tx;

import cool.houge.domain.group.GroupDao;
import cool.houge.domain.model.Group;
import cool.houge.domain.user.UserDao;
import cool.houge.infra.service.GroupServiceImpl;
import cool.houge.infra.tx.TxOps;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class TxGroupServiceImpl extends GroupServiceImpl {

  private final TxOps txOps;

  public @Inject TxGroupServiceImpl(TxOps txOps, GroupDao groupDao, UserDao userDao) {
    super(groupDao, userDao);
    this.txOps = txOps;
  }

  @Override
  public Mono<Integer> create(Group group) {
    return super.create(group).as(txOps::tx);
  }
}
