package cool.houge.infra.dao;

import static org.assertj.core.api.Assertions.assertThat;

import cool.houge.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/** @author KK (kzou227@qq.com) */
class UserDaoImplTest extends AbstractTestDao {

  UserDaoImpl userDao;

  @BeforeEach
  void setup() {
    this.userDao = new UserDaoImpl(rc);
  }

  @Test
  void insert() {
    var user = new User();
    user.setOriginUid(FAKER_CN.idNumber().valid());

    txOps
        .tx(userDao.insert(user))
        .as(StepVerifier::create)
        .assertNext(id -> assertThat(id).as("用户ID必须大于1").isGreaterThan(1))
        .expectComplete()
        .verify();
  }
}
