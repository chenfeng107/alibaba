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
package cool.houge.pivot.main;

import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;
import cool.houge.infra.guice.BasisModule;
import cool.houge.infra.guice.JooqModule;
import cool.houge.infra.guice.ServiceModule;
import cool.houge.infra.system.identifier.ApplicationIdentifier;
import cool.houge.pivot.module.PivotModule;
import cool.houge.pivot.server.PivotServer;
import cool.houge.pivot.server.PivotServerConfig;
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
public class PivotMain implements Runnable {

  private static final Logger log = LogManager.getLogger();
  private static final String CONFIG_FILE = "houge-pivot.conf";
  private final AppShutdownHelper shutdownHelper = new AppShutdownHelper();

  public static void main(String[] args) {
    new PivotMain().run();
  }

  @Override
  public void run() {
    var config = loadConfig();
    var injector =
        Guice.createInjector(
            new BasisModule(config), new JooqModule(), new ServiceModule(), new PivotModule());
    var applicationIdentifier = injector.getInstance(ApplicationIdentifier.class);

    // 启动服务
    var pivotServer =
        new PivotServer(
            ConfigBeanFactory.create(
                config.getConfig(PivotServerConfig.ROOT_CONFIG_NAME), PivotServerConfig.class),
            findBindableServices(injector));
    pivotServer.start();

    // 清理应用的钩子
    shutdownHelper
        .addCallback(pivotServer::stop)
        // 清理应用程序标识
        .addCallback(applicationIdentifier::clean)
        .run();
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