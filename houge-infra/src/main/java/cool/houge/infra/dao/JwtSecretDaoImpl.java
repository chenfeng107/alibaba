package cool.houge.infra.dao;

import cool.houge.domain.model.JwtSecret;
import cool.houge.domain.shared.JwtSecretDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import javax.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class JwtSecretDaoImpl implements JwtSecretDao {

  private final String INSERT_SQL =
      "INSERT INTO t_jwt_secret(id,algorithm,secret) VALUES($1,$2,$3)";
  private final String REMOVE_SQL = "UPDATE t_jwt_secret SET deleted=$1 WHERE id=$2";
  private final String GET_SQL = "SELECT * FROM t_jwt_secret WHERE id=$1";
  private final String GET_ALL_SQL = "SELECT * FROM t_jwt_secret";

  private final R2dbcClient rc;

  public @Inject JwtSecretDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(JwtSecret m) {
    return rc.use(
            spec ->
                spec.sql(INSERT_SQL)
                    .bind("$1", m.getId())
                    .bind("$2", m.getAlgorithm())
                    .bind("$3", m.getSecret())
                    .rowsUpdated())
        .single();
  }

  @Override
  public Mono<Integer> remove(String id) {
    return rc.use(
            spec ->
                spec.sql(REMOVE_SQL)
                    .bind("$1", System.currentTimeMillis() / 1000)
                    .bind("$2", id)
                    .rowsUpdated())
        .single();
  }

  @Override
  public Mono<JwtSecret> get(String id) {
    return rc.use(spec -> spec.sql(GET_SQL).bind("$1", id).fetch(this::mapEntity)).singleOrEmpty();
  }

  @Override
  public Flux<JwtSecret> getAll() {
    return rc.use(spec -> spec.sql(GET_ALL_SQL).fetch(this::mapEntity));
  }

  private JwtSecret mapEntity(Row row) {
    var e = new JwtSecret();
    e.setId(row.get("id", String.class));
    e.setAlgorithm(row.get("algorithm", String.class));
    e.setSecret(row.get("secret", byte[].class));
    e.setDeleted(row.get("deleted", Long.class));
    e.setVer(row.get("ver", Integer.class));
    e.setCreateTime(row.get("create_time", LocalDateTime.class));
    e.setUpdateTime(row.get("update_time", LocalDateTime.class));
    return e;
  }
}
