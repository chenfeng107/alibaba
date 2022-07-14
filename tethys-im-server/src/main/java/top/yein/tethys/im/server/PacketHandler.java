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
package top.yein.tethys.im.server;

import javax.annotation.Nonnull;
import reactor.core.publisher.Mono;
import top.yein.tethys.packet.Packet;
import top.yein.tethys.session.Session;

/**
 * 消息处理器.
 *
 * @author KK (kzou227@qq.com)
 */
@FunctionalInterface
public interface PacketHandler<T extends Packet> {

  /**
   * 消息包处理器.
   *
   * @param session 发送者会话
   * @param packet 消息包
   * @return RS
   */
  Mono<Void> handle(@Nonnull Session session, @Nonnull T packet);
}