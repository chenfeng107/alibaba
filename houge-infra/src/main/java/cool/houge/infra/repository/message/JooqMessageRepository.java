package cool.houge.infra.repository.message;

import static cool.houge.infra.db.Tables.MESSAGE;
import static cool.houge.infra.db.Tables.USER_MESSAGE;

import cool.houge.domain.Paging;
import cool.houge.domain.model.Message;
import cool.houge.domain.repository.message.MessageQueryRepository;
import cool.houge.domain.repository.message.MessageRepository;
import cool.houge.domain.repository.message.UserMessageQuery;
import java.util.List;
import javax.inject.Inject;
import org.jooq.DSLContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class JooqMessageRepository implements MessageRepository, MessageQueryRepository {

  private final DSLContext dsl;

  @Inject
  public JooqMessageRepository(DSLContext dsl) {
    this.dsl = dsl;
  }

  @Override
  public Mono<Message> queryById(String id) {
    return null;
  }

  @Override
  public Flux<Message> queryByUser(UserMessageQuery q, Paging paging) {
    Flux.from(
            dsl.select(MESSAGE.fields())
                .from(USER_MESSAGE)
                .leftJoin(MESSAGE)
                .on(USER_MESSAGE.MESSAGE_ID.eq(MESSAGE.ID))
                .where(USER_MESSAGE.UID.eq(q.getUid()))
            //
            )
        .map(r -> r.into(MESSAGE));
    return null;
  }

  @Override
  public Mono<Void> insert(Message entity, List<Long> uids) {
    return null;
  }

  @Override
  public Mono<Void> updateUnreadStatus(long uid, List<String> messageIds, int v) {
    return null;
  }
}
