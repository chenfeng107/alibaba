package cool.houge.infra.dao;

import cool.houge.domain.model.User;
import cool.houge.domain.model.UserMsg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/** @author KK (kzou227@qq.com) */
class UserMsgDaoImplTest extends AbstractTestDao {

  UserMsgDaoImpl userMsgDao;

  @BeforeEach
  void setup() {
    this.userMsgDao = new UserMsgDaoImpl(super.rc);
  }

  @Test
  void insert() {
    var msg = new UserMsg();
    msg.setId(FAKER_CN.random().hex(15))
        .setSend(new User().setId(1))
        .setRec(new User().setId(2))
        .setContent(FAKER_CN.random().hex())
        .setContentType(0)
        .setExtra("Extra");

    txOps
        .tx(userMsgDao.insert(msg))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        //
        .verify();
  }

  @Test
  void insertNoExtra() {
    var msg = new UserMsg();
    msg.setId(FAKER_CN.random().hex(15))
        .setSend(new User().setId(1))
        .setRec(new User().setId(2))
        .setContent(FAKER_CN.random().hex())
        .setContentType(0);

    txOps
        .tx(userMsgDao.insert(msg))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        //
        .verify();
  }
}
