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
package cool.houge.logic.handler.internal;

import cool.houge.constants.MessageKind;
import cool.houge.logic.packet.MessagePacket;
import cool.houge.entity.Message;

/** @author KK (kzou227@qq.com) */
public class MessagePacketHelper {

  /**
   * @param packet
   * @return
   */
  public static Message toMessageEntity(MessagePacket packet) {
    var entity = new Message();
    entity.setId(packet.getMessageId());
    entity.setSenderId(packet.getFrom());
    if (MessageKind.forCode(packet.getKind()).isGroup()) {
      entity.setGroupId(packet.getTo());
    } else {
      entity.setReceiverId(packet.getTo());
    }
    entity.setKind(packet.getKind());
    entity.setContent(packet.getContent());
    entity.setContentType(packet.getContentType());
    entity.setExtraArgs(packet.getExtraArgs());
    return entity;
  }
}
