package cool.houge.rest.facade.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/** @author KK (kzou227@qq.com) */
@Getter
@Setter
@Accessors(chain = true)
public class UserOutput {

  /** 用户ID. */
  private int uid;
}
