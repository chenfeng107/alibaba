package cool.houge.ws.packet;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 个人信息包.
 *
 * @author KK (kzou227@qq.com)
 */
@Data
@Accessors(chain = true)
public class ProfilePacket implements Packet {

  /** 用户ID. */
  private int uid;
  /** 问候语 */
  private String greeting;

  @Override
  public String getNs() {
    return NS_PROFILE;
  }
}
