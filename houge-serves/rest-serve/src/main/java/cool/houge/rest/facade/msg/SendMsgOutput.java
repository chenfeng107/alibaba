package cool.houge.rest.facade.msg;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 发送消息输出.
 *
 * @author KK (kzou227@qq.com)
 */
@Data
@Accessors(chain = true)
public class SendMsgOutput {

  /** 消息ID. */
  private String msgId;
}
