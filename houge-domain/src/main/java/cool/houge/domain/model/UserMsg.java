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

import cool.houge.domain.EnumLite;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 个人消息.
 *
 * @author KK (kzou227@qq.com)
 */
@Data
@Accessors(chain = true)
public class UserMsg {

  /** 系统消息类型. */
  public static final int KIND_SYSTEM = 1;
  /** 私聊消息类型. */
  public static final int KIND_PRIVATE = 2;
  /** 群组消息类型. */
  public static final int KIND_GROUP = 3;

  /** 消息 ID. */
  private String id;
  /** 发送人. */
  private User send;
  /** 接收人. */
  private User rec;
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
   * @see ReadStatus
   */
  private Integer unread;
  /** 创建时间. */
  private LocalDateTime createTime;
  /** 更新时间. */
  private LocalDateTime updateTime;

  /**
   * 消息读取状态枚举.
   *
   * <p>{@link #UNRECOGNIZED} 是枚举的空值.
   *
   * @author KK (kzou227@qq.com)
   */
  public enum ReadStatus implements EnumLite {

    /** 不认识未被承认的枚举. */
    UNRECOGNIZED(-1),
    /** 已读状态. */
    READ(0),
    /** 未读状态. */
    UNREAD(1),
    ;

    private final int code;

    ReadStatus(int code) {
      this.code = code;
    }

    @Override
    public int getCode() {
      return code;
    }

    /**
     * 将给定数值转换为枚举.
     *
     * <p>如果给定的数值未查找到对应的枚举则会返回 {@link #UNRECOGNIZED}.
     *
     * @param code 对应枚举项的数值
     * @return 与给定数值关联的枚举
     */
    public static ReadStatus forCode(Integer code) {
      if (code == null) {
        return UNRECOGNIZED;
      }
      if (code == READ.code) {
        return READ;
      }
      if (code == UNREAD.code) {
        return UNREAD;
      }
      return UNRECOGNIZED;
    }
  }
}
