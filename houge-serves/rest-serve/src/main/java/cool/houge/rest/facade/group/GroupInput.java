package cool.houge.rest.facade.group;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/** @author KK (kzou227@qq.com) */
@Data
@Accessors(chain = true)
public class GroupInput {

  /** 源群组ID. */
  private String originGid;
  /** 成员用户IDs. */
  private List<Integer> memberUids;
}
