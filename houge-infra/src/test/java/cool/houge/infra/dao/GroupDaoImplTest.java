package cool.houge.infra.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import cool.houge.domain.model.Group;
import cool.houge.domain.model.User;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/** @author KK (kzou227@qq.com) */
class GroupDaoImplTest extends AbstractTestDao {

  GroupDaoImpl dao;

  @BeforeEach
  void setup() {
    this.dao = new GroupDaoImpl(super.rc);
  }

  @Test
  void insert() {
    var m = newModel();
    dao.insert(m)
        .as(txOps::tx)
        .as(StepVerifier::create)
        .assertNext(id -> assertThat(id).isGreaterThan(1))
        .expectComplete()
        .verify();
  }

  @Test
  void updateMemberUids() {
    var m = newModel();
    dao.insert(m)
        .flatMap(
            id -> {
              var newModel = new Group();
              newModel.setId(id).setMemberUids(List.of(m.getCreator().getId())).setVer(1);
              return dao.updateMemberUids(newModel);
            })
        .as(txOps::tx)
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        .verify();
  }

  @Test
  void get() {
    var m = newModel();
    dao.insert(m)
        .flatMap(dao::get)
        .as(txOps::tx)
        .as(StepVerifier::create)
        .consumeNextWith(
            dbRow ->
                assertSoftly(
                    s -> {
                      s.assertThat(dbRow.getId()).as("id").isGreaterThan(1);
                      s.assertThat(dbRow.getCreator().getId())
                          .as("creatorUid")
                          .isEqualTo(m.getCreator().getId());
                      s.assertThat(dbRow.getVer()).as("ver").isEqualTo(1);
                      s.assertThat(dbRow.getCreateTime()).as("createTime").isNotNull();
                      s.assertThat(dbRow.getUpdateTime()).as("updateTime").isNotNull();
                    }))
        .expectComplete()
        .verify();
  }

  Group newModel() {
    var m = new Group();

    m.setCreator(new User().setId(Integer.MIN_VALUE));
    m.setMemberUids(List.of());
    //    m.setOwner(new User().setId(Integer.MIN_VALUE));
    return m;
  }
}
