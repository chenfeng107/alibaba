package cool.houge.rest.facade.token;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/** @author KK (kzou227@qq.com) */
@Setter
@Getter
@Accessors(chain = true)
public class TokenInput {

  private int uid;
}
