package cool.houge.rest.facade.token;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/** @author KK (kzou227@qq.com) */
@Getter
@Setter
@Accessors(chain = true)
public class TokenOutput {

  private String token;
}
