package cool.houge.infra.service.tx;

import cool.houge.domain.model.User;
import cool.houge.domain.user.UserDao;
import cool.houge.domain.user.UserQueryDao;
import cool.houge.infra.service.UserServiceImpl;
import cool.houge.infra.tx.TxOps;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class TxUserServiceImpl extends UserServiceImpl {

  private final TxOps txOps;

  public @Inject TxUserServiceImpl(TxOps txOps, UserDao userDao, UserQueryDao userQueryDao) {
    super(userDao, userQueryDao);
    this.txOps = txOps;
  }

  @Override
  public Mono<Integer> create(User user) {
    return txOps.tx(Mono.defer(() -> super.create(user)));
  }
}
