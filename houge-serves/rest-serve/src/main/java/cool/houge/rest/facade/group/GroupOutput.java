package cool.houge.rest.facade.group;

import lombok.Data;
import lombok.experimental.Accessors;

/** @author KK (kzou227@qq.com) */
@Data
@Accessors(chain = true)
public class GroupOutput {

  /** 群组ID. */
  private int gid;
}
