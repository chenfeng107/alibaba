package cool.houge.infra.dao;

import cool.houge.domain.model.User;
import cool.houge.domain.user.UserDao;
import cool.houge.domain.user.UserQueryDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class UserDaoImpl implements UserDao, UserQueryDao {

  private final R2dbcClient rc;

  public @Inject UserDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(User m) {
    return rc.use(
            spec ->
                spec.sql("INSERT INTO t_user(origin_uid) values(?origin_id)")
                    .bind("origin_id", m.getOriginUid(), String.class)
                    .returnGeneratedValues("id")
                    .fetch(row -> row.get("id", Integer.class)))
        .single();
  }

  @Override
  public Mono<User> queryById(int id) {
    return rc.use(
            spec -> spec.sql("SELECT * FROM t_user WHERE id=?id").bind("id", id).fetch(this::map))
        .single();
  }

  User map(Row row) {
    var m = new User();
    m.setId(row.get("id", Integer.class));
    m.setOriginUid(row.get("origin_uid", String.class));
    m.setCreateTime(row.get("create_time", LocalDateTime.class));
    return m;
  }
}
