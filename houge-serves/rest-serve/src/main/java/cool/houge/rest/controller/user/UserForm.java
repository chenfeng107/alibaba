package cool.houge.rest.controller.user;

import lombok.Builder;
import lombok.Value;

/** @author KK (kzou227@qq.com) */
@Value
@Builder
public class UserForm {

  /** 源用户ID. */
  private String originUid;
}
