package cool.houge.domain.auth;

import lombok.Builder;
import lombok.Value;

/**
 * 令牌信息.
 *
 * @author KK (kzou227@qq.com)
 */
@Value
@Builder
public class TokenInfo {

  /** 用户ID. */
  private int uid;
}
