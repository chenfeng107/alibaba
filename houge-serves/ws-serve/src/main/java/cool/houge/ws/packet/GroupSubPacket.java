package cool.houge.ws.packet;

import java.util.Set;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群组消息订阅.
 *
 * @author KK (kzou227@qq.com)
 */
@Data
@Accessors(chain = true)
public class GroupSubPacket implements Packet {

  private Set<Integer> groupIds;

  @Override
  public String getNs() {
    return NS_GROUP_SUB;
  }
}
