package cool.houge.infra.repository.group;

import com.google.common.annotations.VisibleForTesting;
import cool.houge.Nil;
import cool.houge.domain.model.Group;
import cool.houge.domain.repository.group.GroupQueryRepository;
import cool.houge.domain.repository.group.GroupRepository;
import cool.houge.infra.repository.PostgreSqlStates;
import cool.houge.r2dbc.R2dbcClient;
import io.r2dbc.spi.R2dbcDataIntegrityViolationException;
import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.yein.chaos.biz.BizCode;
import top.yein.chaos.biz.BizCodeException;
import top.yein.chaos.biz.StacklessBizCodeException;

public class PostgreGroupRepository implements GroupRepository, GroupQueryRepository {

  private static final Logger log = LogManager.getLogger();

  private static final String NEXT_GID_SQL = "select nextval('groups_id_seq')";
  private static final String INSERT_GROUP_SQL =
      "INSERT INTO groups(id,creator_id,owner_id,member_size,create_time,update_time)"
          + " VALUES($1,$2,$3,$4,now(),now())";
  private static final String DELETE_GROUP_SQL = "DELETE FROM groups WHERE id=$1";
  private static final String DELETE_MEMBERS_SQL = "DELETE FROM groups_member WHERE gid=$1";
  private static final String INC_MEMBER_SIZE_SQL =
      "UPDATE GROUPS SET member_size=member_size+$1 WHERE id=$2";
  private static final String DEC_MEMBER_SIZE_SQL =
      "UPDATE GROUPS SET member_size=member_size-$1 WHERE id=$2";
  private static final String INSERT_MEMBER_SQL =
      "INSERT INTO groups_member(gid,uid,create_time) VALUES($1,$2,now())";
  private static final String DELETE_MEMBER_SQL =
      "DELETE FROM groups_member WHERE gid=$1 AND uid=$2";

  private static final String QUERY_BY_ID_SQL = "SELECT * FROM groups WHERE id=$1";
  private static final String QUERY_MEMBERS_UID_SQL = "SELECT uid FROM groups_member WHERE gid=$1";
  private static final String QUERY_GID_BY_UID = "SELECT gid FROM groups_member WHERE uid=$1";
  private static final String EXISTS_BY_ID_SQL = "SELECT COUNT(*) FROM groups WHERE id=$1";

  private final R2dbcClient rc;

  /**
   * 使用 R2DBC 客户端构造对象.
   *
   * @param rc R2DBC 客户端
   */
  @Inject
  public PostgreGroupRepository(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Long> insert(Group entity) {
    return Mono.justOrEmpty(entity.getId())
        .switchIfEmpty(nextGroupId())
        .flatMap(
            id -> {
              // 保存群组信息
              var m1 =
                  rc.sql(INSERT_GROUP_SQL)
                      .bind(
                          new Object[] {
                            id,
                            entity.getCreator().getId(),
                            entity.getOwner().getId(),
                            entity.getMemberSize()
                          })
                      .rowsUpdated();

              // 保存群组成员关系
              var m2 =
                  rc.sql(INSERT_MEMBER_SQL)
                      .bind(new Object[] {id, entity.getCreator().getId()})
                      .rowsUpdated();
              return Mono.zip(m1, m2).thenReturn(id);
            })
        .onErrorMap(
            R2dbcDataIntegrityViolationException.class,
            ex -> {
              log.debug("群组已存在 {} ~ {}", entity, ex.getMessage());
              if (PostgreSqlStates.S23505.equals(ex.getSqlState())) {
                return new StacklessBizCodeException(BizCode.C810, "群组已存在", ex);
              }
              return ex;
            });
  }

  @Override
  public Mono<Void> delete(long gid) {
    var m1 = rc.sql(DELETE_GROUP_SQL).bind(0, gid).rowsUpdated();
    var m2 = rc.sql(DELETE_MEMBERS_SQL).bind(0, gid).rowsUpdated();
    return m1.zipWith(m2).then();
  }

  @Override
  public Mono<Void> joinMember(long gid, long uid) {
    // 新增群组-用户关系映射
    var m1 =
        rc.sql(INSERT_MEMBER_SQL)
            .bind(new Object[] {gid, uid})
            .rowsUpdated()
            .onErrorMap(
                R2dbcDataIntegrityViolationException.class,
                ex -> {
                  log.debug("已是群成员 gid={} uid={} ~ {}", gid, uid, ex.getMessage());
                  if (PostgreSqlStates.S23505.equals(ex.getSqlState())) {
                    return new StacklessBizCodeException(BizCode.C810, "已是群成员", ex)
                        .addContextValue("gid", gid)
                        .addContextValue("uid", uid);
                  }
                  return ex;
                })
            .doOnNext(
                n -> {
                  if (n != 1) {
                    throw new BizCodeException(BizCode.C811, "joinMember 增加群成员关系异常")
                        .addContextValue("gid", gid)
                        .addContextValue("uid", uid);
                  }
                });

    // 增加成员数量
    var m2 =
        incMemberSize(gid, 1)
            .doOnNext(
                n -> {
                  if (n != 1) {
                    throw new BizCodeException(BizCode.C811, "joinMember 增加群成员数量异常")
                        .addContextValue("gid", gid)
                        .addContextValue("uid", uid);
                  }
                });
    return Mono.zip(m1, m2).then();
  }

  @Override
  public Mono<Void> removeMember(long gid, long uid) {
    // 移除群组-用户关系映射
    var m1 =
        rc.sql(DELETE_MEMBER_SQL)
            .bind(new Object[] {gid, uid})
            .rowsUpdated()
            .doOnNext(
                n -> {
                  if (n != 1) {
                    throw new BizCodeException(BizCode.C811, "removeMember 移除群成员关系异常")
                        .addContextValue("gid", gid)
                        .addContextValue("uid", uid);
                  }
                });
    // 减少成员数量
    var m2 =
        decMemberSize(gid, 1)
            .doOnNext(
                n -> {
                  if (n != 1) {
                    throw new BizCodeException(BizCode.C811, "removeMember 减少群成员数量异常")
                        .addContextValue("gid", gid)
                        .addContextValue("uid", uid);
                  }
                });
    return Mono.zip(m1, m2).then();
  }

  @VisibleForTesting
  Mono<Integer> incMemberSize(long id, int size) {
    return rc.sql(INC_MEMBER_SIZE_SQL).bind(0, size).bind(1, id).rowsUpdated();
  }

  @VisibleForTesting
  Mono<Integer> decMemberSize(long id, int size) {
    return rc.sql(DEC_MEMBER_SIZE_SQL).bind(0, size).bind(1, id).rowsUpdated();
  }

  @Override
  public Mono<Group> queryById(long id) {
    return rc.sql(QUERY_BY_ID_SQL).bind(0, id).map(this::mapToGroup).one();
  }

  @Override
  public Flux<Long> queryUidByGid(long id) {
    return rc.sql(QUERY_MEMBERS_UID_SQL).bind(0, id).map(row -> row.get(0, Long.class)).all();
  }

  @Override
  public Flux<Long> queryGidByUid(long uid) {
    return rc.sql(QUERY_GID_BY_UID).bind(0, uid).map(row -> row.get(0, Long.class)).all();
  }

  @Override
  public Mono<Nil> existsById(long id) {
    return rc.sql(EXISTS_BY_ID_SQL)
        .bind(0, id)
        .map(row -> row.get(0, Integer.class))
        .one()
        .flatMap(count -> Objects.equals(count, 1) ? Nil.mono() : Mono.empty());
  }

  private Group mapToGroup(Row row) {
    var e = new Group();
    e.setId(row.get("id", Long.class));
    // FIXME 完善逻辑
    //    e.setCreatorId(row.get("creator_id", Long.class));
    //    e.setOwnerId(row.get("owner_id", Long.class));
    e.setMemberSize(row.get("member_size", Integer.class));
    e.setCreateTime(row.get("create_time", LocalDateTime.class));
    e.setUpdateTime(row.get("update_time", LocalDateTime.class));
    return e;
  }

  private Mono<Long> nextGroupId() {
    return Mono.defer(() -> rc.sql(NEXT_GID_SQL).map(row -> row.get(0, Long.class)).one());
  }
}
