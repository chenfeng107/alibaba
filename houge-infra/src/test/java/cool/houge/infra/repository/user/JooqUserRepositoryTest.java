package cool.houge.infra.repository.user;

import static cool.houge.infra.db.Tables.USER;
import static org.assertj.core.api.Assertions.assertThat;

import cool.houge.domain.model.User;
import io.r2dbc.spi.ConnectionFactories;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * {@link JooqUserRepository}.
 *
 * @author KK (kzou227@qq.com)
 */
class JooqUserRepositoryTest {

  @Test
  void insert() {
    var connectionFactory =
        ConnectionFactories.get(
            "r2dbc:pool:postgresql://postgres:hellohuixin@192.168.1.106:5432/houge?validationQuery=SELECT%201");
    var dsl = DSL.using(connectionFactory, SQLDialect.POSTGRES);
    var repos = new JooqUserRepository(dsl);
    var model = new User().setId(10L).setOriginUid("HELLO");
    var p = repos.insert(model);
    StepVerifier.create(p)
        .assertNext(
            id -> assertThat(id).isPositive()
            //
            )
        .expectComplete()
        .verify();

    // 清理数据
    Flux.from(
            dsl.delete(USER).where(USER.ID.eq(model.getId()))
            //
            )
        .blockLast();
  }
}
