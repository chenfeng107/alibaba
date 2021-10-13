/**
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
package io.zhudy.xim.packet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Packet 解析及响应规范定义.
 *
 * <p>所有 IM 消息会话都需要继续该接口, 该接口定义了标准的解析及响应规范.
 *
 * @author Kevin Zou (kevinz@weghst.com)
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "ns")
@JsonPropertyOrder("ns")
public interface Packet {

  /** 全局消息分组 ID. */
  String GROUP_ID_ALL = "all";

  /**
   * 命名空间.
   *
   * @return 命名空间
   * @see Namespaces
   */
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  String getNs();
}
