package cool.houge.infra.dao;

import static cool.houge.infra.dao.ConnectionHelper.connectionMono;

import cool.houge.domain.model.User;
import cool.houge.domain.user.UserDao;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class UserDaoImpl implements UserDao {

  @Override
  public Mono<Integer> insert(User m) {
    return connectionMono(
            conn -> {
              return conn.createStatement("INSERT INTO t_user(origin_uid) values(?)")
                  .bind(0, m.getOriginUid())
                  .returnGeneratedValues("id")
                  .execute();
            })
        .flatMap(
            rs ->
                Mono.from(
                    rs.map((row, rowMetadata) -> row.get("id", Integer.class))
                    //
                    ));
  }
}
