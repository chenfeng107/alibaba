package cool.houge.infra.service;

import cool.houge.domain.group.GroupDao;
import cool.houge.domain.group.GroupService;
import cool.houge.domain.model.Group;
import cool.houge.domain.user.UserDao;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.retry.Retry;

/** @author KK (kzou227@qq.com) */
public class GroupServiceImpl implements GroupService {

  private final GroupDao groupDao;
  private final UserDao userDao;

  public GroupServiceImpl(GroupDao groupDao, UserDao userDao) {
    this.groupDao = groupDao;
    this.userDao = userDao;
  }

  @Override
  public Mono<Integer> create(Group group) {
    return groupDao
        .insert(group)
        .delayUntil(
            gid -> {
              return Flux.fromIterable(group.getMemberUids())
                  .flatMap(uid -> updateGroupIds(uid, gid));
            });
  }

  Mono<Void> updateGroupIds(int uid, int gid) {
    // FIXME 完善这里的逻辑
    var retry = Retry.anyOf(IllegalArgumentException.class).retryMax(10);
    var p =
        userDao
            .get(uid)
            .flatMap(
                user -> {
                  var groupIds = new LinkedHashSet<>(user.getGroupIds());
                  groupIds.add(gid);
                  user.setGroupIds(new ArrayList<>(groupIds));
                  return userDao.updateGroupIds(user);
                })
            .doOnNext(
                n -> {
                  if (n != 1) {
                    // retry
                  }
                });
    return retry.apply(p).then();
  }
}
