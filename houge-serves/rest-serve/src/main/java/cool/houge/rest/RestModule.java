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

import com.google.common.collect.ImmutableMap;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigValue;
import cool.houge.ConfigKeys;
import cool.houge.grpc.ReactorTokenGrpc;
import cool.houge.grpc.ReactorTokenGrpc.ReactorTokenStub;
import cool.houge.grpc.ReactorUserGrpc;
import cool.houge.grpc.ReactorUserGrpc.ReactorUserStub;
import cool.houge.rest.controller.msg.MsgController;
import cool.houge.rest.controller.token.TokenController;
import cool.houge.rest.controller.user.UserController;
import cool.houge.rest.facade.token.TokenFacade;
import cool.houge.rest.facade.user.UserFacade;
import cool.houge.rest.interceptor.AkskInterceptor;
import cool.houge.rest.interceptor.Interceptors;
import cool.houge.rest.interceptor.TokenInterceptor;
import cool.houge.rest.web.RoutingService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

/**
 * REST Guice 模块.
 *
 * @author KK (kzou227@qq.com)
 */
public class RestModule extends AbstractModule {

  private final Config config;

  /**
   * 使用应用配置构建对象.
   *
   * @param config 应用配置
   */
  public RestModule(Config config) {
    this.config = config;
  }

  @Override
  protected void configure() {
    bind(Config.class).toInstance(config);
    bind(RestServer.class).in(Scopes.SINGLETON);

    // Facade
    bind(TokenFacade.class).in(Scopes.SINGLETON);
    bind(UserFacade.class).in(Scopes.SINGLETON);

    // 绑定 Web 访问资源对象
    bind(TokenInterceptor.class).in(Scopes.SINGLETON);
    // 控制器注册
    var multibinder = Multibinder.newSetBinder(binder(), RoutingService.class);
    multibinder.addBinding().to(TokenController.class).in(Scopes.SINGLETON);
    multibinder.addBinding().to(MsgController.class).in(Scopes.SINGLETON);
    multibinder.addBinding().to(UserController.class).in(Scopes.SINGLETON);
  }

  @Provides
  @Singleton
  public Interceptors interceptors(TokenInterceptor tokenInterceptor) {
    return new Interceptors(tokenInterceptor::handle, akskInterceptor()::handle);
  }

  // ======================= FIXME 完善aksk认证逻辑 =======================
  private AkskInterceptor akskInterceptor() {
    var basicUsersBuilder = ImmutableMap.<String, String>builder();
    if (config.hasPath(ConfigKeys.SERVICE_AUTH_BASIC)) {
      for (Entry<String, ConfigValue> entry :
          config.getConfig(ConfigKeys.SERVICE_AUTH_BASIC).entrySet()) {
        basicUsersBuilder.put(entry.getKey(), entry.getValue().unwrapped().toString());
      }
    }
    return new AkskInterceptor(basicUsersBuilder.build());
  }

  @Singleton
  @Provides
  public ManagedChannel managedChannel() {
    var target = config.getString("rest.poplar.grpc-target");
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
  public ReactorTokenStub tokenStub(ManagedChannel managedChannel) {
    return ReactorTokenGrpc.newReactorStub(managedChannel);
  }

  @Singleton
  @Provides
  public ReactorUserStub userStub(ManagedChannel managedChannel) {
    return ReactorUserGrpc.newReactorStub(managedChannel);
  }
}
