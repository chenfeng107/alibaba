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

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;
import com.typesafe.config.Config;
import cool.houge.infra.guice.DaoModule;
import cool.houge.infra.id.MessageIdGenerator;
import cool.houge.infra.id.YeinGidMessageIdGenerator;
import cool.houge.infra.system.identifier.AppIdentifier;
import cool.houge.poplar.grpc.ReactorHybridGrpcImpl;
import io.grpc.BindableService;

/**
 * LogicGuice模块.
 *
 * @author KK (kzou227@qq.com)
 */
public class PoplarModule extends AbstractModule {

  private final Config config;

  public PoplarModule(Config config) {
    this.config = config;
  }

  @Override
  protected void configure() {
    install(new DaoModule());

    bind(Config.class).toInstance(config);
    bind(PoplarServer.class);

    bind(AppIdentifier.class).to(PoplarAppIdentifier.class).in(Scopes.SINGLETON);
    bind(MessageIdGenerator.class).to(YeinGidMessageIdGenerator.class).in(Scopes.SINGLETON);

    // 认证服务
    //    bind(JwsAuthService.class).in(Scopes.SINGLETON);
    //    bind(AuthService.class).to(JwsAuthService.class);

    // 绑定 gRPC
    var grpcBinder = Multibinder.newSetBinder(binder(), BindableService.class);
    grpcBinder.addBinding().to(ReactorHybridGrpcImpl.class).in(Scopes.SINGLETON);
  }
}
