package cool.houge.domain.msg;

import cool.houge.domain.model.UserMsg;
import java.util.List;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface UserMsgDao {

  /**
   * @param msg
   * @return
   */
  Mono<Integer> insert(UserMsg msg);

  /**
   * @param ids
   * @return
   */
  Mono<Integer> updateUnread(List<String> ids);
}
