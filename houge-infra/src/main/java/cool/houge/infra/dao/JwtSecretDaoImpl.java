package cool.houge.infra.dao;

import cool.houge.domain.model.JwtSecret;
import cool.houge.domain.shared.JwtSecretDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class JwtSecretDaoImpl implements JwtSecretDao {

  private final R2dbcClient rc;

  public JwtSecretDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(JwtSecret m) {
    return rc.use(
            spec ->
                spec.sql(
                        "INSERT INTO jwt_secrets(id,algorithm,secret) VALUES(?id,?algorithm,?secret)")
                    .bind("id", m.getId())
                    .bind("algorithm", m.getAlgorithm())
                    .bind("secret", m.getSecret())
                    .rowsUpdated())
        .single();
  }

  @Override
  public Mono<Integer> delete(String id) {
    return rc.use(
            spec ->
                spec.sql("UPDATE jwt_secrets SET deleted=?deleted WHERE id=?id")
                    .bind("deleted", System.currentTimeMillis() / 1000)
                    .bind("id", id)
                    .rowsUpdated())
        .single();
  }

  @Override
  public Mono<JwtSecret> findById(String id) {
    return rc.use(
            spec ->
                spec.sql("SELECT * FROM jwt_secrets WHERE id=?id")
                    .bind("id", id)
                    .map(this::mapEntity)
                    .one())
        .singleOrEmpty();
  }

  @Override
  public Flux<JwtSecret> findAll() {
    return rc.use(spec -> spec.sql("SELECT * FROM jwt_secrets").map(this::mapEntity).all());
  }

  private JwtSecret mapEntity(Row row) {
    var e = new JwtSecret();
    e.setId(row.get("id", String.class));
    e.setAlgorithm(row.get("algorithm", String.class));
    e.setSecret(row.get("secret", byte[].class));
    e.setDeleted(row.get("deleted", Integer.class));
    e.setCreateTime(row.get("create_time", LocalDateTime.class));
    e.setUpdateTime(row.get("update_time", LocalDateTime.class));
    return e;
  }
}
