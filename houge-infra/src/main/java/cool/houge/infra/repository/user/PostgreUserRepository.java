package cool.houge.infra.repository.user;

import cool.houge.Nil;
import cool.houge.domain.model.User;
import cool.houge.domain.repository.user.UserQueryRepository;
import cool.houge.domain.repository.user.UserRepository;
import cool.houge.infra.repository.PostgreSqlStates;
import cool.houge.r2dbc.Parameter;
import cool.houge.r2dbc.R2dbcClient;
import io.r2dbc.spi.R2dbcDataIntegrityViolationException;
import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;
import top.yein.chaos.biz.BizCode;
import top.yein.chaos.biz.StacklessBizCodeException;

public class PostgreUserRepository implements UserRepository, UserQueryRepository {

  private static final Logger log = LogManager.getLogger();

  private static final String NEXT_ID_SQL = "SELECT NEXTVAL('users_id_seq')";
  private static final String INSERT_SQL =
      "INSERT INTO users(id,origin_uid,create_time,update_time) VALUES($1,$2,NOW(),NOW())";
  private static final String QUERY_BY_ID_SQL = "SELECT * FROM users WHERE id=$1";
  private static final String EXISTS_BY_ID_SQL = "SELECT COUNT(*) FROM users WHERE id=$1";

  private final R2dbcClient rc;

  /**
   * 使用 R2DBC 客户端构造对象.
   *
   * @param rc R2DBC 客户端
   */
  @Inject
  public PostgreUserRepository(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Long> insert(User entity) {
    return Mono.justOrEmpty(entity.getId())
        .switchIfEmpty(nextUserId())
        .flatMap(
            id ->
                rc.sql(INSERT_SQL)
                    .bind(
                        new Object[] {
                          id, Parameter.fromOrNull(entity.getOriginUid(), String.class)
                        })
                    .rowsUpdated()
                    .thenReturn(id))
        .onErrorMap(
            R2dbcDataIntegrityViolationException.class,
            ex -> {
              log.debug("用户已存在 {} ~ {}", entity, ex.getMessage());
              if (PostgreSqlStates.S23505.equals(ex.getSqlState())) {
                return new StacklessBizCodeException(BizCode.C810, "用户已存在", ex);
              }
              return ex;
            });
  }

  @Override
  public Mono<cool.houge.model.User> queryById(long id) {
    return rc.sql(QUERY_BY_ID_SQL).bind(0, id).map(this::mapToEntity).one();
  }

  @Override
  public Mono<Nil> existsById(long id) {
    return rc.sql(EXISTS_BY_ID_SQL)
        .bind(0, id)
        .map(row -> row.get(0, Integer.class))
        .one()
        .flatMap(count -> Objects.equals(count, 1) ? Nil.mono() : Mono.empty());
  }

  private cool.houge.model.User mapToEntity(Row row) {
    var e = new cool.houge.model.User();
    e.setId(row.get("id", Long.class));
    e.setOriginUid(row.get("origin_uid", String.class));
    e.setCreateTime(row.get("create_time", LocalDateTime.class));
    e.setUpdateTime(row.get("update_time", LocalDateTime.class));
    return e;
  }

  private Mono<Long> nextUserId() {
    return Mono.defer(() -> rc.sql(NEXT_ID_SQL).map(row -> row.get(0, Long.class)).one());
  }
}
