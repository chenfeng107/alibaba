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
package cool.houge.ws.packet;

import lombok.Setter;
import lombok.ToString;

/**
 * 通用的消息包.
 *
 * @author KK (kzou227@qq.com)
 */
@ToString
@Setter
public abstract class BaseMsgPacket implements MsgPacket {

  /** 消息 ID 全局唯一. */
  String msgId;
  /** 发送消息者. */
  Integer from;
  /** 接收消息者. */
  int to;
  /** 消息类型. */
  int kind;
  /** 消息内容. */
  String content;
  /** 消息类型. */
  int contentType;
  /** 扩展参数. */
  String extra;

  @Override
  public String getMsgId() {
    return msgId;
  }

  @Override
  public Integer getFrom() {
    return from;
  }

  @Override
  public int getTo() {
    return to;
  }

  @Override
  public int getKind() {
    return kind;
  }

  @Override
  public String getContent() {
    return content;
  }

  @Override
  public int getContentType() {
    return contentType;
  }

  @Override
  public String getExtra() {
    return extra;
  }
}
