package cool.houge.infra.dao;

import cool.houge.domain.group.GroupDao;
import cool.houge.domain.group.GroupQueryDao;
import cool.houge.domain.model.Group;
import cool.houge.infra.r2dbc.R2dbcClient;
import java.time.LocalDateTime;
import java.util.Arrays;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class GroupDaoImpl implements GroupDao, GroupQueryDao {

  private final String INSERT_SQL = "INSERT INTO t_group(origin_gid,member_uids) VALUES($1,$2)";
  private final String UPDATE_MEMBER_UIDS_SQL =
      "UPDATE t_group SET member_uids=$1,ver=ver+1 WHERE id=$2 AND ver=$3";
  private final String GET_SQL = "SELECT * FROM t_group WHERE id=$1";

  private final R2dbcClient rc;

  public @Inject GroupDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(Group m) {
    return rc.use(
            spec ->
                spec.sql(INSERT_SQL)
                    .bind("$1", m.getOriginGid(), String.class)
                    .bind("$2", m.getMemberUids().toArray(new Integer[] {}))
                    .returnGeneratedValues("id")
                    .fetch(row -> row.get("id", Integer.class)))
        .single();
  }

  @Override
  public Mono<Integer> updateMemberUids(Group m) {
    return rc.use(
            spec ->
                spec.sql(UPDATE_MEMBER_UIDS_SQL)
                    .bind("$1", m.getMemberUids().toArray(new Integer[] {}))
                    .bind("$2", m.getId())
                    .bind("$3", m.getVer())
                    .rowsUpdated())
        .single();
  }

  @Override
  public Mono<Group> get(int id) {
    return rc.use(
            spec ->
                spec.sql(GET_SQL)
                    .bind("$1", id)
                    .fetch(
                        row -> {
                          var m = new Group();
                          m.setId(row.get("id", Integer.class));
                          m.setOriginGid(row.get("origin_gid", String.class));
                          m.setMemberUids(Arrays.asList(row.get("member_uids", Integer[].class)));
                          m.setVer(row.get("ver", Integer.class));
                          m.setCreateTime(row.get("create_time", LocalDateTime.class));
                          m.setUpdateTime(row.get("update_time", LocalDateTime.class));
                          return m;
                        }))
        .singleOrEmpty();
  }
}
