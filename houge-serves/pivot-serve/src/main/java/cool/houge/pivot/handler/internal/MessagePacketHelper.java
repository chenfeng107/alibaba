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
package cool.houge.pivot.handler.internal;

import cool.houge.domain.constants.MessageKind;
import cool.houge.domain.model.Group;
import cool.houge.domain.model.Message;
import cool.houge.domain.model.User;
import cool.houge.pivot.packet.MessagePacket;

/** @author KK (kzou227@qq.com) */
public class MessagePacketHelper {

  /**
   * @param packet
   * @return
   */
  public static Message toMessageEntity(MessagePacket packet) {
    var entity = new Message();
    if (MessageKind.forCode(packet.getKind()).isGroup()) {
      entity.setGroup(new Group().setId(packet.getTo()));
    } else {
      entity.setReceiver(new User().setId(packet.getTo()));
    }

    entity
        .setId(packet.getMessageId())
        .setSender(new User().setId(packet.getFrom()))
        .setKind(packet.getKind())
        .setContent(packet.getContent())
        .setContentType(packet.getContentType())
        .setExtraArgs(packet.getExtraArgs());
    return entity;
  }
}
