package cool.houge.infra.dao;

import cool.houge.infra.TestBase;
import cool.houge.infra.r2dbc.DefaultR2dbcClient;
import cool.houge.infra.r2dbc.R2dbcClient;
import cool.houge.infra.tx.TxOps;
import io.r2dbc.spi.ConnectionFactories;
import org.junit.jupiter.api.BeforeEach;

/** @author KK (kzou227@qq.com) */
public abstract class AbstractTestDao extends TestBase {

  /** 事务操作对象. */
  protected TxOps txOps;

  protected R2dbcClient rc;

  @BeforeEach
  void setupTxOps() {
    var url = config().getString("r2dbc.url");
    var connectionFactory = ConnectionFactories.get(url);
    this.rc = new DefaultR2dbcClient(connectionFactory);
    this.txOps = new TxOps(connectionFactory, true);
  }
}
