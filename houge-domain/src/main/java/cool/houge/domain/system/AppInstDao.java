package cool.houge.domain.system;

import cool.houge.domain.model.AppInst;
import reactor.core.publisher.Mono;

/**
 * 应用实例数据访问接口.
 *
 * @author KK (kzou227@qq.com)
 */
public interface AppInstDao {

  /**
   * 新增应用服务实例.
   *
   * @param m 实体
   * @return RS
   */
  Mono<Integer> insert(AppInst m);

  /**
   * 删除应用服务实例.
   *
   * @param id 应用 ID
   * @return RS
   */
  Mono<Integer> delete(int id);

  /**
   * 更新最后检查时间.
   *
   * @param id 应用 ID
   * @return RS
   */
  Mono<Integer> updateCheckTime(int id);

  /**
   * 查询应用服务实例.
   *
   * @param id 应用 ID
   * @return 实体
   */
  Mono<AppInst> get(int id);
}
