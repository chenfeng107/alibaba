package cool.houge.infra.guice;

import static io.r2dbc.spi.ConnectionFactoryOptions.CONNECT_TIMEOUT;
import static io.r2dbc.spi.ConnectionFactoryOptions.STATEMENT_TIMEOUT;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.typesafe.config.Config;
import cool.houge.domain.group.GroupDao;
import cool.houge.domain.msg.MsgDao;
import cool.houge.domain.shared.JwtSecretDao;
import cool.houge.domain.system.AppInstDao;
import cool.houge.domain.user.UserDao;
import cool.houge.infra.dao.AppInstDaoImpl;
import cool.houge.infra.dao.GroupDaoImpl;
import cool.houge.infra.dao.JwtSecretDaoImpl;
import cool.houge.infra.dao.MsgDaoImpl;
import cool.houge.infra.dao.UserDaoImpl;
import cool.houge.infra.r2dbc.DefaultR2dbcClient;
import cool.houge.infra.r2dbc.R2dbcClient;
import cool.houge.infra.tx.TxOps;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;
import java.time.Duration;

/**
 * Guice DAO模块.
 *
 * @author KK (kzou227@qq.com)
 */
public class DaoModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(JwtSecretDao.class).to(JwtSecretDaoImpl.class).asEagerSingleton();
    bind(AppInstDao.class).to(AppInstDaoImpl.class).asEagerSingleton();
    bind(UserDao.class).to(UserDaoImpl.class).asEagerSingleton();
    bind(GroupDao.class).to(GroupDaoImpl.class).asEagerSingleton();
    bind(MsgDao.class).to(MsgDaoImpl.class).asEagerSingleton();
  }

  @Provides
  public ConnectionFactory connectionFactory(Config config) {
    var url = config.getString("poplar.r2dbc.url");
    var options =
        ConnectionFactoryOptions.parse(url)
            .mutate()
            .option(CONNECT_TIMEOUT, Duration.ofSeconds(3))
            .option(STATEMENT_TIMEOUT, Duration.ofSeconds(10))
            .option(Option.valueOf("useServerPrepareStatement"), true)
            .option(Option.valueOf("tcpKeepAlive"), true)
            .option(Option.valueOf("tcpNoDelay"), true)
            .build();
    return ConnectionFactories.get(options);
  }

  @Provides
  public R2dbcClient r2dbcClient(ConnectionFactory connectionFactory) {
    return new DefaultR2dbcClient(connectionFactory);
  }

  @Provides
  public TxOps txOps(ConnectionFactory connectionFactory) {
    return new TxOps(connectionFactory, false);
  }
}
