package cool.houge.infra.dao;

import static org.assertj.core.api.Assertions.assertThat;

import cool.houge.domain.model.Group;
import cool.houge.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/** @author KK (kzou227@qq.com) */
class GroupDaoImplTest extends AbstractTestDao {

  GroupDaoImpl groupDao;

  @BeforeEach
  void setup() {
    this.groupDao = new GroupDaoImpl(super.rc);
  }

  @Test
  void insert() {
    var m = newModel();
    txOps
        .tx(groupDao.insert(m))
        .as(StepVerifier::create)
        .assertNext(id -> assertThat(id).isGreaterThan(1))
        .expectComplete()
        .verify();
  }

  @Test
  void joinMember() {
    var m = newModel();
    txOps
        .tx(groupDao.insert(m).flatMap(id -> groupDao.joinMember(id, 1)))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        .verify();
  }

  @Test
  void joinMemberNonexistentGroup() {
    txOps
        .tx(groupDao.joinMember(Integer.MIN_VALUE, 1))
        .as(StepVerifier::create)
        .expectNext(0)
        .expectComplete()
        .verify();
  }

  @Test
  void removeMember() {
    var m = newModel();
    txOps
        .tx(groupDao.insert(m).flatMap(id -> groupDao.removeMember(id, m.getOwner().getId())))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        .verify();
  }

  @Test
  void removeMemberNonexistentGroup() {
    txOps
        .tx(groupDao.removeMember(Integer.MIN_VALUE, 1))
        .as(StepVerifier::create)
        .expectNext(0)
        .expectComplete()
        .verify();
  }

  @Test
  void removeMemberNonexistentMember() {
    var m = newModel();
    txOps
        .tx(groupDao.insert(m).flatMap(id -> groupDao.removeMember(id, 1)))
        .as(StepVerifier::create)
        .expectNext(0)
        .expectComplete()
        .verify();
  }

  @Test
  void incMemberSize() {
    var m = newModel();
    txOps
        .tx(groupDao.insert(m).flatMap(id -> groupDao.incMemberSize(id, 1)))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        .verify();
  }

  Group newModel() {
    var m = new Group();
    m.setCreator(new User().setId(Integer.MIN_VALUE));
    m.setOwner(new User().setId(Integer.MIN_VALUE));
    return m;
  }
}
