package cool.houge.infra.repository.group;

import static cool.houge.infra.db.Tables.GROUP;
import static cool.houge.infra.db.Tables.GROUP_MEMBER;

import cool.houge.Nil;
import cool.houge.domain.model.Group;
import cool.houge.domain.repository.group.GroupQueryRepository;
import cool.houge.domain.repository.group.GroupRepository;
import cool.houge.infra.db.Sequences;
import cool.houge.infra.db.tables.records.GroupMemberRecord;
import cool.houge.infra.db.tables.records.GroupRecord;
import javax.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.Record1;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class JooqGroupRepository implements GroupRepository, GroupQueryRepository {

  private final DSLContext dsl;

  @Inject
  public JooqGroupRepository(DSLContext dsl) {
    this.dsl = dsl;
  }

  @Override
  public Mono<Long> insert(Group model) {
    return Mono.just(model.getId())
        .switchIfEmpty(nextId())
        .flatMap(
            gid -> {
              var record =
                  new GroupRecord()
                      .setId(gid)
                      .setCreatorId(model.getCreator().getId())
                      .setOwnerId(model.getOwner().getId())
                      .setMemberSize(model.getMemberSize());
              return Mono.from(dsl.insertInto(GROUP).set(record)).thenReturn(gid);
            })
        .flatMap(
            gid -> {
              var record = new GroupMemberRecord().setGid(gid).setUid(model.getCreator().getId());
              return Mono.from(dsl.insertInto(GROUP_MEMBER).set(record)).thenReturn(gid);
            });
  }

  @Override
  public Mono<Void> delete(long gid) {
    return Mono.from(
            dsl.delete(GROUP).where(GROUP.ID.eq(gid))
            //
            )
        .thenMany(
            dsl.delete(GROUP_MEMBER).where(GROUP_MEMBER.GID.eq(gid))
            //
            )
        .then();
  }

  @Override
  public Mono<Void> joinMember(long gid, long uid) {
    return null;
  }

  @Override
  public Mono<Void> removeMember(long gid, long uid) {
    return null;
  }

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

  private Mono<Long> nextId() {
    return Mono.from(dsl.select(Sequences.GROUP_ID_SEQ.nextval())).map(Record1::value1);
  }
}
