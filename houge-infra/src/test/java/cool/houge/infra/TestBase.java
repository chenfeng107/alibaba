package cool.houge.infra;

import com.github.javafaker.Faker;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.Locale;

/**
 * 测试基础类.
 *
 * @author KK (kzou227@qq.com)
 */
public class TestBase {

  /** 中文假数据生成器. */
  protected static final Faker FAKER_CN = new Faker(Locale.SIMPLIFIED_CHINESE);

  /**
   * 返回测试配置对象.
   *
   * @return 配置对象
   */
  public Config config() {
    return ConfigHolder.CONFIG;
  }

  private static class ConfigHolder {

    static final Config CONFIG;

    static {
      CONFIG = ConfigFactory.parseResources("houge-test.conf");
      System.out.println(CONFIG.root().render());
    }
  }
}
