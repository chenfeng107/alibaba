package cool.houge.infra.dao;

import cool.houge.domain.model.Group;
import cool.houge.domain.model.GroupMsg;
import cool.houge.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/** @author KK (kzou227@qq.com) */
class GroupMsgDaoImplTest extends AbstractTestDao {

  GroupMsgDaoImpl groupMsgDao;

  @BeforeEach
  void setup() {
    this.groupMsgDao = new GroupMsgDaoImpl(super.rc);
  }

  @Test
  void insert() {
    var msg = new GroupMsg();
    msg.setId(FAKER_CN.random().hex(15))
        .setSend(new User().setId(1))
        .setGroup(new Group().setId(2))
        .setContent(FAKER_CN.random().hex())
        .setContentType(0)
        .setExtra("Extra");

    txOps
        .tx(groupMsgDao.insert(msg))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        //
        .verify();
  }

  @Test
  void insertNoExtra() {
    var msg = new GroupMsg();
    msg.setId(FAKER_CN.random().hex(15))
        .setSend(new User().setId(1))
        .setGroup(new Group().setId(2))
        .setContent(FAKER_CN.random().hex())
        .setContentType(0);

    txOps
        .tx(groupMsgDao.insert(msg))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        //
        .verify();
  }
}
