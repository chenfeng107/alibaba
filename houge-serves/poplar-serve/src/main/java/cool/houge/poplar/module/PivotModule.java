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
package cool.houge.poplar.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import cool.houge.domain.auth.AuthService;
import cool.houge.grpc.AgentGrpc;
import cool.houge.infra.id.MessageIdGenerator;
import cool.houge.infra.id.YeinGidMessageIdGenerator;
import cool.houge.infra.service.auth.JwsAuthService;
import cool.houge.infra.system.identifier.ApplicationIdentifier;
import cool.houge.poplar.agent.PacketSender;
import cool.houge.poplar.agent.ServerAgentManager;
import cool.houge.poplar.agent.TediousServerAgentManager;
import cool.houge.poplar.grpc.ReactorAgentGrpcImpl;
import cool.houge.poplar.handler.GroupMessageHandler;
import cool.houge.poplar.handler.PacketHandler;
import cool.houge.poplar.handler.PrivateMessageHandler;
import cool.houge.poplar.packet.Packet;
import cool.houge.poplar.support.PivotApplicationIdentifier;
import io.grpc.BindableService;

/**
 * LogicGuice模块.
 *
 * @author KK (kzou227@qq.com)
 */
public class PivotModule extends AbstractModule {

  @Override
  protected void configure() {
    // 消息分发器
    bind(TediousServerAgentManager.class).in(Scopes.SINGLETON);
    bind(PacketSender.class).to(TediousServerAgentManager.class);
    bind(ServerAgentManager.class).to(TediousServerAgentManager.class);

    bind(ApplicationIdentifier.class).to(PivotApplicationIdentifier.class).in(Scopes.SINGLETON);
    bind(MessageIdGenerator.class).to(YeinGidMessageIdGenerator.class).in(Scopes.SINGLETON);

    // 认证服务
    bind(JwsAuthService.class).in(Scopes.SINGLETON);
    bind(AuthService.class).to(JwsAuthService.class);

    // 绑定 PacketHandler
    bind(PacketHandler.class)
        .annotatedWith(Names.named(Packet.NS_PRIVATE_MESSAGE))
        .to(PrivateMessageHandler.class)
        .in(Scopes.SINGLETON);
    bind(PacketHandler.class)
        .annotatedWith(Names.named(Packet.NS_GROUP_MESSAGE))
        .to(GroupMessageHandler.class)
        .in(Scopes.SINGLETON);

    // 绑定 gRPC
    bind(BindableService.class)
        .annotatedWith(Names.named(AgentGrpc.SERVICE_NAME))
        .to(ReactorAgentGrpcImpl.class)
        .in(Scopes.SINGLETON);
  }
}
