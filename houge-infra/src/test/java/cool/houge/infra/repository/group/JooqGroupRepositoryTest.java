package cool.houge.infra.repository.group;

import static cool.houge.infra.db.Tables.GROUP;
import static cool.houge.infra.db.Tables.GROUP_MEMBER;
import static org.assertj.core.api.Assertions.assertThat;

import cool.houge.domain.model.Group;
import cool.houge.domain.model.User;
import cool.houge.infra.repository.JooqTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/**
 * {@link JooqGroupRepository}.
 *
 * @author KK (kzou227@qq.com)
 */
class JooqGroupRepositoryTest extends JooqTestBase {

  JooqGroupRepository repos;

  @BeforeEach
  void beforeEach() {
    this.repos = new JooqGroupRepository(dsl);
  }

  @Test
  void insert() {
    var user = new User().setId(faker.random().nextLong());
    var model =
        new Group()
            .setId(faker.random().nextLong())
            .setCreator(user)
            .setOwner(user)
            .setMemberSize(1);
    var p = repos.insert(model);
    StepVerifier.create(p)
        .expectNext(model.getId())
        //
        .expectComplete()
        .verify();

    // 清理数据
    clean(model.getId());
  }

  void clean(long gid) {
    StepVerifier.create(
            dsl.delete(GROUP).where(GROUP.ID.eq(gid))
            //
            )
        .expectNext(1)
        .expectComplete()
        .verify();
    StepVerifier.create(
            dsl.delete(GROUP_MEMBER).where(GROUP_MEMBER.GID.eq(gid))
            //
            )
        .assertNext(n -> assertThat(n).isPositive())
        .expectComplete()
        .verify();
  }
}
