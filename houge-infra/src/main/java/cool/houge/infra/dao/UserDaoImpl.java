package cool.houge.infra.dao;

import cool.houge.Nil;
import cool.houge.domain.BizCodes;
import cool.houge.domain.model.User;
import cool.houge.domain.user.UserDao;
import cool.houge.domain.user.UserQueryDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import io.r2dbc.spi.R2dbcDataIntegrityViolationException;
import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import java.util.Arrays;
import javax.inject.Inject;
import reactor.core.publisher.Mono;
import top.yein.chaos.biz.StacklessBizCodeException;

/** @author KK (kzou227@qq.com) */
public class UserDaoImpl implements UserDao, UserQueryDao {

  private final String INSERT_SQL = "INSERT INTO t_user(origin_uid) VALUES($1)";
  private final String GET_SQL = "SELECT * FROM t_user WHERE id=$1";
  private final String EXISTS_SQL = "SELECT 1 FROM t_user WHERE id=$1";

  private final R2dbcClient rc;

  public @Inject UserDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(User m) {
    return rc.use(
            spec -> {
              return spec.sql(INSERT_SQL)
                  .bind("$1", m.getOriginUid(), String.class)
                  .returnGeneratedValues("id")
                  .fetch(row -> row.get("id", Integer.class));
            })
        .onErrorMap(
            R2dbcDataIntegrityViolationException.class,
            e -> {
              // origin_uid 唯一索引冲突
              if ("23000".equals(e.getSqlState())) {
                return new StacklessBizCodeException(BizCodes.C3000, e.getMessage());
              }
              return e;
            })
        .single();
  }

  @Override
  public Mono<User> get(int id) {
    return rc.use(spec -> spec.sql(GET_SQL).bind("$1", id).fetch(this::map)).singleOrEmpty();
  }

  @Override
  public Mono<Nil> exists(int uid) {
    return rc.use(spec -> spec.sql(EXISTS_SQL).bind("$1", uid).fetch())
        .singleOrEmpty()
        .map(unused -> Nil.INSTANCE);
  }

  User map(Row row) {
    var m = new User();
    m.setId(row.get("id", Integer.class));
    m.setOriginUid(row.get("origin_uid", String.class));
    var groupIds = row.get("group_ids", Integer[].class);
    if (groupIds != null) {
      m.setGroupIds(Arrays.asList(groupIds));
    }
    m.setVer(row.get("ver", Integer.class));
    m.setCreateTime(row.get("create_time", LocalDateTime.class));
    m.setUpdateTime(row.get("update_time", LocalDateTime.class));
    return m;
  }
}
