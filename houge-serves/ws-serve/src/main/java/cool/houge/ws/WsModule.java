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

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.typesafe.config.Config;
import cool.houge.grpc.ReactorAuthGrpc;
import cool.houge.grpc.ReactorAuthGrpc.ReactorAuthStub;
import cool.houge.grpc.ReactorMsgGrpc;
import cool.houge.grpc.ReactorMsgGrpc.ReactorMsgStub;
import cool.houge.ws.session.DefaultSessionGroupManager;
import cool.houge.ws.session.DefaultSessionManager;
import cool.houge.ws.session.SessionGroupManager;
import cool.houge.ws.session.SessionManager;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

/**
 * WS的Guice模块.
 *
 * @author KK (kzou227@qq.com)
 */
public class WsModule extends AbstractModule {

  private final Config config;

  /**
   * 使用应用配置构造对象.
   *
   * @param config 应用配置
   */
  public WsModule(Config config) {
    this.config = config;
  }

  @Override
  protected void configure() {
    bind(Config.class).toInstance(config);
    bind(WsServer.class).in(Scopes.SINGLETON);
    bind(LibService.class).in(Scopes.SINGLETON);

    bind(WebSocketHandler.class).in(Scopes.SINGLETON);
    bind(SessionManager.class).to(DefaultSessionManager.class).in(Scopes.SINGLETON);
    bind(SessionGroupManager.class).to(DefaultSessionGroupManager.class).in(Scopes.SINGLETON);
  }

  @Singleton
  @Provides
  public ManagedChannel grpcManagedChannel() {
    var target = config.getString("ws.polar.grpc-target");
    var managedChannel =
        ManagedChannelBuilder.forTarget(target)
            .enableRetry()
            .usePlaintext()
            .maxRetryAttempts(3)
            .idleTimeout(5, TimeUnit.MINUTES)
            .keepAliveWithoutCalls(true)
            .build();
    return managedChannel;
  }

  @Singleton
  @Provides
  public ReactorAuthStub authStub(ManagedChannel grpcManagedChannel) {
    return ReactorAuthGrpc.newReactorStub(grpcManagedChannel);
  }

  @Singleton
  @Provides
  public ReactorMsgStub msgStub(ManagedChannel grpcManagedChannel) {
    return ReactorMsgGrpc.newReactorStub(grpcManagedChannel);
  }
}
