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
package cool.houge.domain.model;

import cool.houge.domain.constants.MsgReadStatus;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * {@code t_message} 消息表.
 *
 * @author KK (kzou227@qq.com)
 */
@Data
@Accessors(chain = true)
public class Msg {

  /** 系统消息类型. */
  public static final int KIND_SYSTEM = 1;
  /** 私聊消息类型. */
  public static final int KIND_PRIVATE = 2;
  /** 群组消息类型. */
  public static final int KIND_GROUP = 3;

  /** 消息 ID. */
  private String id;
  /** 发送人. */
  private User sender;
  /** 接收人 ID. */
  private User receiver;
  /** 群主 ID. */
  private Group group;
  /**
   * 消息类型.
   *
   * <ul>
   *   <li>{@code 1}: 系统消息
   *   <li>{@code 2}: 私聊消息
   *   <li>{@code 3}: 群组消息
   * </ul>
   */
  private Integer kind;
  /** 消息内容. */
  private String content;
  /**
   * 消息内容类型.
   *
   * <ul>
   *   <li>{@code 1}: 普通文本消息
   *   <li>{@code 2}: 图片消息
   *   <li>{@code 3}: 音频消息
   *   <li>{@code 4}: 视频消息
   * </ul>
   */
  private Integer contentType;
  /** 扩展参数. */
  private String extra;
  /**
   * 消息是否未读.
   *
   * @see MsgReadStatus
   */
  private Integer unread;
  /** 创建时间. */
  private LocalDateTime createTime;
  /** 更新时间. */
  private LocalDateTime updateTime;
}