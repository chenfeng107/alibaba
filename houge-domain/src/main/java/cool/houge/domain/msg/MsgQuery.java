package cool.houge.domain.msg;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;

/** @author KK (kzou227@qq.com) */
@Value
@Builder
public class MsgQuery {

  private Integer uid;
  private LocalDateTime beginTime;
}
