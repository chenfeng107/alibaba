package cool.houge.domain.model;

import cool.houge.domain.EnumLite;

/**
 * 消息内容类型枚举定义.
 *
 * <p>{@link #UNRECOGNIZED} 是枚举的空值.
 */
public enum MsgContentType implements EnumLite {

  /**
   * 不认识未被承认的枚举.
   */
  UNRECOGNIZED(-1),
  /**
   * 普通文本消息.
   */
  TEXT(0),
  /**
   * 图片消息.
   */
  IMAGE(1),
  /**
   * 语音消息.
   */
  VOICE(2),
  /**
   * 视频消息.
   */
  VIDEO(3),
  ;
  private final int code;

  MsgContentType(int code) {
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
  public static MsgContentType forCode(Integer code) {
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
