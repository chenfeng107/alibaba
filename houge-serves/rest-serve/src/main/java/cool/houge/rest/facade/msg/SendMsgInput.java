package cool.houge.rest.facade.msg;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 发送消息.
 *
 * @author KK (kzou227@qq.com)
 */
@Data
@Accessors(chain = true)
public class SendMsgInput {

  /**
   * 消息类型.
   *
   * <ul>
   *   <li>{@link cool.houge.protos.MsgKind#USER}
   *   <li>{@link cool.houge.protos.MsgKind#GROUP}
   * </ul>
   */
  private int kind;
  /** 消息接收者用户ID. */
  private int to;
  /** 消息内容. */
  private String content;
  /** 消息内容类型. */
  private int contentType;
  /** 扩展参数. */
  private String extra;
}
