package cool.houge.infra.dao;

import cool.houge.domain.model.User;
import cool.houge.domain.user.UserDao;
import reactor.core.publisher.Mono;

import static cool.houge.infra.dao.ConnectionHelper.connectionMono;

/**
 * @author KK (kzou227@qq.com)
 */
public class UserDaoImpl implements UserDao {

  @Override
  public Mono<Integer> insert(User m) {
    return connectionMono(
        conn -> {
          var s = conn.createStatement("INSERT INTO t_user(origin_uid) values($origin_id)");
          if (m.getOriginUid() == null) {
            s.bindNull("origin_id", String.class);
          } else {
            s.bind("origin_id", m.getOriginUid());
          }
          return s.returnGeneratedValues("id").execute();
        })
        .flatMap(
            rs ->
                Mono.from(
                    rs.map((row, rowMetadata) -> row.get("id", Integer.class))
                    //
                ));
  }
}
