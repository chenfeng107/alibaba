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

  /**
   * 消息类型枚举.
   *
   * <p>{@link #UNRECOGNIZED} 是枚举的空值.
   */
  public static enum Kind implements EnumLite {

    /** 不认识未被承认的枚举. */
    UNRECOGNIZED(-1, false, false),
    /** 私聊消息. */
    P_MESSAGE(0, false, false),
    /** 群组消息. */
    G_MESSAGE(1, true, false),
    /** 系统消息<b>单人</b>. */
    SP_MESSAGE(8, false, true),
    /** 系统消息<b>群组</b>. */
    SG_MESSAGE(9, true, true),
    ;

    private final int code;
    private final boolean group;
    private final boolean system;

    Kind(int code, boolean group, boolean system) {
      this.code = code;
      this.group = group;
      this.system = system;
    }

    @Override
    public int getCode() {
      return this.code;
    }

    /**
     * 返回枚举类型是否为群组消息.
     *
     * @return true/false
     */
    public boolean isGroup() {
      return group;
    }

    /**
     * 返回枚举类型是否为系统消息.
     *
     * @return true/false
     */
    public boolean isSystem() {
      return system;
    }

    /**
     * 将给定数值转换为枚举.
     *
     * <p>如果给定的数值未查找到对应的枚举则会返回 {@link #UNRECOGNIZED}.
     *
     * @param code 对应枚举项的数值
     * @return 与给定数值关联的枚举
     */
    public static Kind forCode(Integer code) {
      if (code == null) {
        return UNRECOGNIZED;
      }
      if (code == P_MESSAGE.code) {
        return P_MESSAGE;
      }
      if (code == G_MESSAGE.code) {
        return G_MESSAGE;
      }
      if (code == SP_MESSAGE.code) {
        return SP_MESSAGE;
      }
      if (code == SG_MESSAGE.code) {
        return SG_MESSAGE;
      }
      return UNRECOGNIZED;
    }
  }

  /**
   * 消息内容类型枚举定义.
   *
   * <p>{@link #UNRECOGNIZED} 是枚举的空值.
   */
  public enum ContentType implements EnumLite {

    /** 不认识未被承认的枚举. */
    UNRECOGNIZED(-1),
    /** 普通文本消息. */
    TEXT(0),
    /** 图片消息. */
    IMAGE(1),
    /** 语音消息. */
    VOICE(2),
    /** 视频消息. */
    VIDEO(3),
    ;
    private final int code;

    ContentType(int code) {
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
    public static ContentType forCode(Integer code) {
      if (code == null) {
        return UNRECOGNIZED;
      }
      if (code == TEXT.code) {
        return TEXT;
      }
      if (code == IMAGE.code) {
        return IMAGE;
      }
      if (code == VOICE.code) {
        return VOICE;
      }
      if (code == VIDEO.code) {
        return VIDEO;
      }
      return UNRECOGNIZED;
    }
  }
}
