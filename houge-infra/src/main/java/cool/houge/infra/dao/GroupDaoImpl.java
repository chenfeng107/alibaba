package cool.houge.infra.dao;

import cool.houge.domain.group.GroupDao;
import cool.houge.domain.model.Group;
import cool.houge.infra.r2dbc.R2dbcClient;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class GroupDaoImpl implements GroupDao {

  private final R2dbcClient rc;

  public @Inject GroupDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(Group m) {
    return rc.use(
            spec ->
                spec.sql("INSERT INTO t_group(creator_id,owner_id) VALUES(?creator_id,?owner_id)")
                    .bind("creator_id", m.getCreator().getId())
                    .bind("owner_id", m.getOwner().getId())
                    .returnGeneratedValues("id")
                    .fetch(row -> row.get("id", Integer.class)))
        .single()
        .flatMap(gid -> insertMember0(gid, m.getOwner().getId()).thenReturn(gid));
  }

  @Override
  public Mono<Integer> joinMember(int gid, int uid) {
    return insertMember0(gid, uid)
        .flatMap(
            n -> {
              if (n != 1) {
                return Mono.just(n);
              }
              return this.incMemberSize(gid, 1);
            });
  }

  @Override
  public Mono<Integer> removeMember(int gid, int uid) {
    return removeMember0(gid, uid)
        .flatMap(
            n -> {
              if (n != 1) {
                return Mono.just(n);
              }
              return this.incMemberSize(gid, -1);
            });
  }

  Mono<Integer> incMemberSize(int id, int delta) {
    return rc.use(
            spec ->
                spec.sql(
                        "UPDATE t_group SET member_size=member_size+?delta,update_time=NOW() WHERE id=?id")
                    .bind("id", id)
                    .bind("delta", delta)
                    .rowsUpdated())
        .single();
  }

  Mono<Integer> insertMember0(int gid, int uid) {
    return rc.use(
            spec ->
                spec.sql("INSERT INTO t_group_member(gid,uid) VALUES(?gid,?uid)")
                    .bind("gid", gid)
                    .bind("uid", uid)
                    .rowsUpdated())
        .single();
  }

  Mono<Integer> removeMember0(int gid, int uid) {
    return rc.use(
            spec ->
                spec.sql("DELETE FROM t_group_member WHERE gid=?gid AND uid=?uid")
                    .bind("gid", gid)
                    .bind("uid", uid)
                    .rowsUpdated())
        .single();
  }
}
