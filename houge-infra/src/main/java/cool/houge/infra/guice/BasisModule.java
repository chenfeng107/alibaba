package cool.houge.infra.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.typesafe.config.Config;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

/**
 * Infra 基础 Guice 模块.
 *
 * @author KK (kzou227@qq.com)
 */
public class BasisModule extends AbstractModule {

  private final Config config;

  /**
   * 使用应用配置初始化.
   *
   * @param config 应用配置
   */
  public BasisModule(Config config) {
    this.config = config;
  }

  @Override
  protected void configure() {
    bind(Config.class).toInstance(config);
  }

  @Provides
  @Singleton
  public ConnectionFactory connectionFactory() {
    var r2dbcUrl = config.getString("message-storage.r2dbc.url");
    var options = ConnectionFactoryOptions.parse(r2dbcUrl).mutate().build();
    return ConnectionFactories.get(options);
  }

  @Provides
  @Singleton
  public DSLContext dsl(ConnectionFactory connectionFactory) {
    var settings = new Settings();
    settings.setRenderFormatted(true);
    return DSL.using(connectionFactory, SQLDialect.POSTGRES, settings);
  }
}
