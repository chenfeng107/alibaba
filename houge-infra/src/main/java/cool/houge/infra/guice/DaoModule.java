package cool.houge.infra.guice;

import static io.r2dbc.spi.ConnectionFactoryOptions.CONNECT_TIMEOUT;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.STATEMENT_TIMEOUT;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.typesafe.config.Config;
import cool.houge.domain.group.GroupDao;
import cool.houge.domain.msg.GroupMsgDao;
import cool.houge.domain.msg.UserMsgDao;
import cool.houge.domain.shared.JwtSecretDao;
import cool.houge.domain.system.AppInstDao;
import cool.houge.domain.user.UserDao;
import cool.houge.domain.user.UserQueryDao;
import cool.houge.infra.dao.AppInstDaoImpl;
import cool.houge.infra.dao.GroupDaoImpl;
import cool.houge.infra.dao.GroupMsgDaoImpl;
import cool.houge.infra.dao.JwtSecretDaoImpl;
import cool.houge.infra.dao.UserDaoImpl;
import cool.houge.infra.dao.UserMsgDaoImpl;
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
    bind(JwtSecretDao.class).to(JwtSecretDaoImpl.class).in(Scopes.SINGLETON);
    bind(AppInstDao.class).to(AppInstDaoImpl.class).in(Scopes.SINGLETON);

    bind(UserDaoImpl.class).in(Scopes.SINGLETON);
    bind(UserDao.class).to(UserDaoImpl.class);
    bind(UserQueryDao.class).to(UserDaoImpl.class);

    bind(GroupDao.class).to(GroupDaoImpl.class).in(Scopes.SINGLETON);
    bind(UserMsgDao.class).to(UserMsgDaoImpl.class).in(Scopes.SINGLETON);
    bind(GroupMsgDao.class).to(GroupMsgDaoImpl.class).in(Scopes.SINGLETON);
  }

  @Provides
  public ConnectionFactory connectionFactory(Config config) {
    var url = config.getString("poplar.r2dbc.url");
    var user = config.getString("poplar.r2dbc.user");
    var password = config.getString("poplar.r2dbc.password");

    var options =
        ConnectionFactoryOptions.parse(url)
            .mutate()
            .option(CONNECT_TIMEOUT, Duration.ofSeconds(3))
            .option(STATEMENT_TIMEOUT, Duration.ofSeconds(10))
            .option(USER, user)
            .option(PASSWORD, password)
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
