package cool.houge.infra.dao;

import cool.houge.domain.model.User;
import cool.houge.infra.tx.TxOps;
import io.r2dbc.spi.ConnectionFactories;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/** @author KK (kzou227@qq.com) */
class UserDaoImplTest {

  @Test
  void insert() {
    var connectionFactory =
        ConnectionFactories.get("r2dbc:mysql://root:7MumshL!4eiK_hK@139.196.11.144:3306/houge");

    var txOps = new TxOps(connectionFactory);

    var userDao = new UserDaoImpl();
    var user = new User();
    user.setOriginUid("hello");

    var rs = txOps.tx(userDao.insert(user));
    StepVerifier.create(rs)
        .consumeNextWith(
            id -> {
              System.out.println("ID: " + id);
            })
        .expectComplete()
        .verify();
  }
}
