/*
 * Copyright 2019-2021 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cool.houge.rest;

import com.google.inject.Guice;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cool.houge.util.AppShutdownHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 主程序.
 *
 * @author KK (kzou227@qq.com)
 */
public class RestMain implements Runnable {

  private static final Logger log = LogManager.getLogger();
  private static final String CONFIG_FILE = "houge-rest.conf";
  private final AppShutdownHelper shutdownHelper = new AppShutdownHelper();

  /**
   * 程序入口.
   *
   * @param args 启动参数
   */
  public static void main(String[] args) {
    new RestMain().run();
  }

  @Override
  public void run() {
    // 1. 初始化配置
    var config = loadConfig();

    // 2. 初始化 Guice
    var injector = Guice.createInjector(new RestModule(config));

    // 3. 启动 REST 服务
    var server = injector.getInstance(RestServer.class);

    server.start();
    log.info("houge-rest 服务启动成功");

    shutdownHelper.addCallback(server::stop).await();
    log.info("houge-rest 服务停止完成");
  }

  private Config loadConfig() {
    var config = ConfigFactory.parseResources(CONFIG_FILE).resolve();
    log.info(
        "已加载的应用配置 \n=========================================================>>>\n{}<<<=========================================================",
        config.root().render());
    return config;
  }
}
