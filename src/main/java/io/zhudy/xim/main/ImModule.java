/*
 * Copyright 2019-2020 the original author or authors
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
package io.zhudy.xim.main;

import static com.google.inject.name.Names.named;
import static io.zhudy.xim.session.SessionGroupManager.SESSION_GROUP_LISTENER_NAME_FOR_IOC;
import static io.zhudy.xim.session.SessionManager.SESSION_LISTENER_NAME_FOR_IOC;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import io.jsonwebtoken.SigningKeyResolver;
import io.zhudy.xim.auth.AuthService;
import io.zhudy.xim.auth.impl.DefaultSigningKeyResolver;
import io.zhudy.xim.auth.impl.JwsAuthService;
import io.zhudy.xim.router.LocalPacketRouter;
import io.zhudy.xim.router.PacketRouter;
import io.zhudy.xim.server.ImServer;
import io.zhudy.xim.server.ImSocketHandler;
import io.zhudy.xim.session.SessionGroupListener;
import io.zhudy.xim.session.SessionGroupManager;
import io.zhudy.xim.session.SessionIdGenerator;
import io.zhudy.xim.session.SessionListener;
import io.zhudy.xim.session.SessionManager;
import io.zhudy.xim.session.impl.DefaultSessionGroupManager;
import io.zhudy.xim.session.impl.DefaultSessionIdGenerator;
import io.zhudy.xim.session.impl.DefaultSessionManager;
import javax.inject.Singleton;

/**
 * Guice IM 模块.
 *
 * @author Kevin Zou (kevinz@weghst.com)
 */
public class ImModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ImServer.class).in(Singleton.class);
    bind(ImSocketHandler.class).in(Singleton.class);

    // 认证
    bind(SigningKeyResolver.class).to(DefaultSigningKeyResolver.class).in(Singleton.class);
    bind(AuthService.class).to(JwsAuthService.class).in(Singleton.class);

    // 会话
    bind(SessionIdGenerator.class).to(DefaultSessionIdGenerator.class).in(Singleton.class);
    bind(SessionManager.class).to(DefaultSessionManager.class).in(Singleton.class);
    // 注册 SessionListener
    {
      Multibinder.newSetBinder(
          binder(), SessionListener.class, named(SESSION_LISTENER_NAME_FOR_IOC));
    }

    bind(SessionGroupManager.class).to(DefaultSessionGroupManager.class).in(Singleton.class);
    // 注册 SessionGroupListener
    {
      Multibinder.newSetBinder(
          binder(), SessionGroupListener.class, named(SESSION_GROUP_LISTENER_NAME_FOR_IOC));
    }

    // Packet
    bind(PacketRouter.class).to(LocalPacketRouter.class).in(Singleton.class);
  }
}
