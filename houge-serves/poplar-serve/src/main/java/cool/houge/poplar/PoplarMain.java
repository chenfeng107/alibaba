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
package cool.houge.poplar;

import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cool.houge.infra.system.identifier.AppIdentifier;
import cool.houge.util.AppShutdownHelper;
import io.grpc.BindableService;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 程序入口.
 *
 * @author KK (kzou227@qq.com)
 */
public class PoplarMain implements Runnable {

  private static final Logger log = LogManager.getLogger();
  private static final String CONFIG_FILE = "houge-poplar.conf";
  private final AppShutdownHelper shutdownHelper = new AppShutdownHelper();

  public static void main(String[] args) {
    new PoplarMain().run();
  }

  @Override
  public void run() {
    var config = loadConfig();
    var injector = Guice.createInjector(new PoplarModule(config));
    var applicationIdentifier = injector.getInstance(AppIdentifier.class);

    // 启动服务
    var poplarServer = injector.getInstance(PoplarServer.class);
    poplarServer.start();

    // 清理应用的钩子
    shutdownHelper
        .addCallback(poplarServer::stop)
        // 清理应用程序标识
        .addCallback(applicationIdentifier::clean)
        .await();
  }

  private Config loadConfig() {
    var config = ConfigFactory.parseResources(CONFIG_FILE).resolve();
    log.info(
        "已加载的应用配置 \n=========================================================>>>\n{}<<<=========================================================",
        config.root().render());
    return config;
  }

  private List<BindableService> findBindableServices(Injector injector) {
    return injector.findBindingsByType(new TypeLiteral<BindableService>() {}).stream()
        .map(Binding::getProvider)
        .map(Provider::get)
        .collect(Collectors.toList());
  }
}
