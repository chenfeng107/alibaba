package cool.houge.domain.msg;

import cool.houge.domain.model.GroupMsg;
import cool.houge.domain.model.UserMsg;
import java.util.List;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface MsgDao {

  /**
   * @param msg
   * @return
   */
  Mono<Integer> insert(UserMsg msg);

  /**
   * @param msg
   * @return
   */
  Mono<Integer> insert(GroupMsg msg);

  /**
   * @param ids
   * @return
   */
  Mono<Integer> updateUserMsgUnread(List<String> ids);
}
