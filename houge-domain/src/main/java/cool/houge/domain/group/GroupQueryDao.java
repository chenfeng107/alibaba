package cool.houge.domain.group;

import cool.houge.domain.model.Group;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface GroupQueryDao {

  /**
   * 查询指定群信息.
   *
   * @param id 群 ID
   * @return 群信息
   */
  Mono<Group> get(int id);
}
