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
import cool.houge.infra.guice.ServiceModule;
import cool.houge.infra.id.MsgIdGenerator;
import cool.houge.infra.id.YeinGidMsgIdGenerator;
import cool.houge.infra.system.identifier.AppIdentifier;
import cool.houge.poplar.broker.BrokerManager;
import cool.houge.poplar.broker.MsgRouter;
import cool.houge.poplar.broker.SimpleMsgRouter;
import cool.houge.poplar.grpc.BrokerGrpcImpl;
import cool.houge.poplar.grpc.GroupGrpcImpl;
import cool.houge.poplar.grpc.MsgGrpcImpl;
import cool.houge.poplar.grpc.TokenGrpcImpl;
import cool.houge.poplar.grpc.UserGrpcImpl;
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
    install(new ServiceModule());

    bind(Config.class).toInstance(config);
    bind(PoplarServer.class);

    bind(AppIdentifier.class).to(PoplarAppIdentifier.class).in(Scopes.SINGLETON);
    bind(MsgIdGenerator.class).to(YeinGidMsgIdGenerator.class).in(Scopes.SINGLETON);

    bind(BrokerManager.class).in(Scopes.SINGLETON);
    bind(MsgRouter.class).to(SimpleMsgRouter.class).in(Scopes.SINGLETON);

    // gRPC实现
    var grpcBinder = Multibinder.newSetBinder(binder(), BindableService.class);
    grpcBinder.addBinding().to(BrokerGrpcImpl.class).in(Scopes.SINGLETON);
    grpcBinder.addBinding().to(TokenGrpcImpl.class).in(Scopes.SINGLETON);
    grpcBinder.addBinding().to(MsgGrpcImpl.class).in(Scopes.SINGLETON);
    grpcBinder.addBinding().to(UserGrpcImpl.class).in(Scopes.SINGLETON);
    grpcBinder.addBinding().to(GroupGrpcImpl.class).in(Scopes.SINGLETON);
  }
}
