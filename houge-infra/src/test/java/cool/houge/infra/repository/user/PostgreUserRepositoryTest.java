package cool.houge.infra.repository.user;

import static org.assertj.core.api.Assertions.assertThat;

import cool.houge.domain.model.User;
import io.r2dbc.spi.ConnectionFactories;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/**
 * {@link JooqUserRepository}.
 *
 * @author KK (kzou227@qq.com)
 */
class PostgreUserRepositoryTest {

  @Test
  void insert() {
    var connectionFactory =
        ConnectionFactories.get(
            "r2dbc:pool:postgresql://postgres:hellohuixin@192.168.1.106:5432/houge?validationQuery=SELECT%201");
    var dsl = DSL.using(connectionFactory, SQLDialect.POSTGRES);
    var repos = new JooqUserRepository(dsl);
    var model = User.builder().id(10L).originUid("HELLO").build();
    var p = repos.insert(model);
    StepVerifier.create(p)
        .assertNext(
            id -> assertThat(id).isPositive()
            //
            )
        .expectComplete()
        .verify();
  }
}
