package cool.houge.infra.repository;

import cool.houge.infra.TestBase;
import io.r2dbc.spi.ConnectionFactories;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.BeforeAll;

/**
 * Jooq 测试基类.
 *
 * @author KK (kzou227@qq.com)
 */
public class JooqTestBase extends TestBase {

  protected static DSLContext dsl;

  @BeforeAll
  public static final void setup() {
    var connectionFactory =
        ConnectionFactories.get(
            "r2dbc:pool:postgresql://postgres:hellohuixin@192.168.1.106:5432/houge?validationQuery=SELECT%201");
    JooqTestBase.dsl = DSL.using(connectionFactory, SQLDialect.POSTGRES);
  }
}
