package cool.houge.rest.facade.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/** @author KK (kzou227@qq.com) */
@Getter
@Setter
@Accessors(chain = true)
public class UserInput {

  /** 源用户ID. */
  private String originUid;
}
