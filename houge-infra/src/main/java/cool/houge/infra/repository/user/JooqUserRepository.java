package cool.houge.infra.repository.user;

import static cool.houge.infra.db.Tables.USER;

import cool.houge.Nil;
import cool.houge.domain.model.User;
import cool.houge.domain.repository.user.UserQueryRepository;
import cool.houge.domain.repository.user.UserRepository;
import cool.houge.infra.db.Sequences;
import javax.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.Record1;
import reactor.core.publisher.Mono;

/**
 * @author KK (kzou227@qq.com)
 */
public class JooqUserRepository implements UserRepository, UserQueryRepository {

  private final DSLContext dsl;

  @Inject
  public JooqUserRepository(DSLContext dsl) {
    this.dsl = dsl;
  }

  @Override
  public Mono<Long> insert(User model) {
    return Mono.just(model.getId())
      .switchIfEmpty(nextId())
      .flatMap(
        id -> {
          var record = UserRecordMapper.INSTANCE.toRecord(id, model);
          return Mono.from(dsl.insertInto(USER).set(record)).thenReturn(id);
        });
  }

  @Override
  public Mono<User> findById(long id) {
    return Mono.from(
        dsl.selectFrom(USER).where(USER.ID.eq(id))
      )
      .map(UserRecordMapper.INSTANCE::toModel);
  }

  @Override
  public Mono<Nil> existsById(long id) {
    return Mono.from(
        dsl.selectCount().where(USER.ID.eq(id))
      )
      .flatMap(r -> r.value1() > 0 ? Nil.mono() : Mono.empty());
  }

  private Mono<Long> nextId() {
    return Mono.from(
        dsl.select(Sequences.USER_ID_SEQ.nextval())
      )
      .map(Record1::value1);
  }
}
