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
package cool.houge.ws.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import cool.houge.grpc.ReactorHybridGrpc;
import cool.houge.grpc.ReactorHybridGrpc.ReactorHybridStub;
import cool.houge.ws.PivotServiceConfig;
import cool.houge.ws.PivotStreamServiceConfig;
import cool.houge.ws.pivot.CommandProcessor;
import cool.houge.ws.pivot.PacketProcessor;
import cool.houge.ws.pivot.PivotStreamServiceManager;
import cool.houge.ws.pivot.command.CommandHandler;
import cool.houge.ws.pivot.command.SubGroupCommandHandler;
import cool.houge.ws.pivot.internal.CommandProcessorImpl;
import cool.houge.ws.pivot.internal.PacketProcessorImpl;
import cool.houge.ws.server.WebSocketHandler;
import cool.houge.ws.server.WsServer;
import cool.houge.ws.server.WsServerConfig;
import cool.houge.ws.session.DefaultSessionGroupManager;
import cool.houge.ws.session.DefaultSessionManager;
import cool.houge.ws.session.SessionGroupManager;
import cool.houge.ws.session.SessionManager;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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
    bind(WebSocketHandler.class).in(Scopes.SINGLETON);
    bind(SessionManager.class).to(DefaultSessionManager.class).in(Scopes.SINGLETON);
    bind(SessionGroupManager.class).to(DefaultSessionGroupManager.class).in(Scopes.SINGLETON);

    bind(PacketProcessor.class).to(PacketProcessorImpl.class).in(Scopes.SINGLETON);
    bind(CommandProcessor.class).to(CommandProcessorImpl.class).in(Scopes.SINGLETON);

    this.bindCommandHandlers();
    this.bindGrpcStub();
  }

  @Provides
  @Singleton
  public WsServer wsServer(WebSocketHandler webSocketHandler) {
    var serverConfig =
        ConfigBeanFactory.create(config.getConfig("ws-server"), WsServerConfig.class);
    return new WsServer(serverConfig, webSocketHandler);
  }

  @Provides
  @Singleton
  public PivotStreamServiceManager clientAgentManager(
      PacketProcessor packetProcessor, CommandProcessor commandProcessor) {
    var agentConfig =
        ConfigBeanFactory.create(
            config.getConfig("pivot-stream-service"), PivotStreamServiceConfig.class);
    return new PivotStreamServiceManager(agentConfig, packetProcessor, commandProcessor);
  }

  private void bindGrpcStub() {
    var logicServiceConfig =
        ConfigBeanFactory.create(config.getConfig("pivot-service"), PivotServiceConfig.class);
    bind(PivotServiceConfig.class).toInstance(logicServiceConfig);

    var managedChannel =
        ManagedChannelBuilder.forTarget(logicServiceConfig.getGrpcTarget())
            .enableRetry()
            .usePlaintext()
            .build();
    bind(ManagedChannel.class).toInstance(managedChannel);

    // gRPC 存根对象注册
    bind(ReactorHybridStub.class).toInstance(ReactorHybridGrpc.newReactorStub(managedChannel));
  }

  private void bindCommandHandlers() {
    var binder = Multibinder.newSetBinder(binder(), CommandHandler.class);
    binder.addBinding().to(SubGroupCommandHandler.class).in(Scopes.SINGLETON);
    //    binder.addBinding().to(UnsubGroupCommandHandler.class).in(Scopes.SINGLETON);
  }
}
