package cool.houge.domain.group;

import cool.houge.domain.model.Group;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface GroupService {

  /**
   * @param group
   * @return
   */
  Mono<Integer> create(Group group);
}
