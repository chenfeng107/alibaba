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
package cool.houge.ws;

import com.google.inject.Guice;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 程序入口.
 *
 * @author KK (kzou227@qq.com)
 */
public class WsMain implements Runnable {

  private static final Logger log = LogManager.getLogger();
  private static final String CONFIG_FILE = "houge-ws.conf";

  public static void main(String[] args) {
    new WsMain().run();
  }

  @Override
  public void run() {
    var config = this.loadConfig();
    var injector = Guice.createInjector(new WsModule(config));

    // 启动 WebSocket 服务
    var wsServer = injector.getInstance(WsServer.class);
    wsServer.start();

    // 停止服务的勾子
    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  try {
                    wsServer.stop();
                  } catch (Exception e) {
                    log.error("停止WebSocket服务异常", e);
                  }

                  try {
                    // FIXME
                  } catch (Exception e) {
                    log.error("停止AgentServiceManager异常", e);
                  }
                },
                "shutdown"));
  }

  private Config loadConfig() {
    var config = ConfigFactory.parseResources(CONFIG_FILE).resolve();
    log.info("应用配置加载成功 file={}", CONFIG_FILE);
    return config;
  }
}
