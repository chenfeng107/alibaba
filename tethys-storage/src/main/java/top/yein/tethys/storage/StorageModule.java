package top.yein.tethys.storage;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.typesafe.config.Config;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import top.yein.tethys.ConfigKeys;
import top.yein.tethys.core.r2dbc.DefaultR2dbcClient;
import top.yein.tethys.r2dbc.R2dbcClient;

/**
 * 消息数据存储模块定义.
 *
 * @author KK (kzou227@qq.com)
 */
public class StorageModule extends AbstractModule {

  private final Config config;

  /**
   * 使用配置创建模块对象.
   *
   * @param config 应用配置
   */
  public StorageModule(Config config) {
    this.config = config;
  }

  @Override
  protected void configure() {
    bind(ServerInstanceDao.class).to(ServerInstanceDaoImpl.class).in(Scopes.SINGLETON);
    bind(JwtSecretDao.class).to(JwtSecretDaoImpl.class).in(Scopes.SINGLETON);
    bind(MessageDao.class).to(MessageDaoImpl.class).in(Scopes.SINGLETON);
  }

  @Provides
  public ConnectionFactory connectionFactory() {
    var r2dbcUrl = config.getString(ConfigKeys.MESSAGE_STORAGE_R2DBC_URL);
    return ConnectionFactories.get(r2dbcUrl);
  }

  @Provides
  public R2dbcClient r2dbcClient(ConnectionFactory connectionFactory) {
    return new DefaultR2dbcClient(connectionFactory);
  }
}