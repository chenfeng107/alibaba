package cool.houge.infra.guice;

import com.google.inject.AbstractModule;
import com.typesafe.config.Config;

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
  }
}
