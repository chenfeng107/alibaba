package cool.houge.infra.service;

import cool.houge.domain.group.GroupDao;
import cool.houge.domain.group.GroupService;
import cool.houge.domain.model.Group;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class GroupServiceImpl implements GroupService {

  private final GroupDao groupDao;

  public GroupServiceImpl(GroupDao groupDao) {
    this.groupDao = groupDao;
  }

  @Override
  public Mono<Integer> create(Group group) {
    return groupDao.insert(group);
  }
}
