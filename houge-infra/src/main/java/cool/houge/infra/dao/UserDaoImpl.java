package cool.houge.infra.dao;

import cool.houge.domain.model.User;
import cool.houge.domain.user.UserDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class UserDaoImpl implements UserDao {

  private final R2dbcClient rc;

  public UserDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(User m) {
    return rc.use(
            spec ->
                spec.sql("INSERT INTO users(origin_uid) values(?origin_id)")
                    .bind("origin_id", m.getOriginUid(), String.class)
                    .returnGeneratedValues("id")
                    .fetch(row -> row.get("id", Integer.class)))
        .single();
  }
}
