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

import lombok.Builder;
import lombok.Value;

/**
 * 错误包.
 *
 * @author KK (kzou227@qq.com)
 */
@Value
@Builder
public class ErrorPacket implements Packet {

  /** 错误码. */
  private int code;
  /** 错误描述. */
  private String message;
  /** 详细描述. */
  private Object details;

  @Override
  public String getNs() {
    return Packet.NS_ERROR;
  }
}
