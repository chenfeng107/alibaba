package cool.houge.domain.msg;

import cool.houge.domain.model.Msg;
import java.util.List;
import java.util.Set;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface MsgDao {

  /**
   * @param msg
   * @param uids
   * @return
   */
  Mono<Void> insert(Msg msg, Set<Integer> uids);

  /**
   * @param ids
   * @return
   */
  Mono<Integer> updateUnread(List<String> ids);
}
