package cool.houge.infra.repository.group;

import cool.houge.Nil;
import cool.houge.domain.model.Group;
import cool.houge.domain.repository.group.GroupQueryRepository;
import cool.houge.domain.repository.group.GroupRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class JooqGroupRepository implements GroupRepository, GroupQueryRepository {

  @Override
  public Mono<Group> findById(long id) {
    return null;
  }

  @Override
  public Flux<Long> findUidByGid(long id) {
    return null;
  }

  @Override
  public Flux<Long> findGidByUid(long uid) {
    return null;
  }

  @Override
  public Mono<Nil> existsById(long id) {
    return null;
  }

  @Override
  public Mono<Long> insert(Group entity) {
    return null;
  }

  @Override
  public Mono<Void> delete(long gid) {
    return null;
  }

  @Override
  public Mono<Void> joinMember(long gid, long uid) {
    return null;
  }

  @Override
  public Mono<Void> removeMember(long gid, long uid) {
    return null;
  }
}
