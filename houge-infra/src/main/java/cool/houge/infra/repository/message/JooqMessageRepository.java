package cool.houge.infra.repository.message;

import static cool.houge.infra.db.Tables.MESSAGE;
import static cool.houge.infra.db.Tables.USER_MESSAGE;

import cool.houge.domain.Paging;
import cool.houge.domain.model.Msg;
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
  public Mono<Void> insert(Msg entity, List<Long> uids) {
    //    var record =
    //        new MessageRecord()
    //            .setId(entity.getId())
    //            .setKind(entity.getKind().shortValue())
    //            .setSenderId(entity.getSender().getId())
    //            .setContent(entity.getContent())
    //            .setContentType(entity.getContentType().shortValue())
    //            .setExtraArgs(entity.getExtra());
    //    if (entity.getReceiver() != null) {
    //      record.setReceiverId(entity.getReceiver().getId());
    //    }
    //    if (entity.getGroup() != null) {
    //      record.setGroupId(entity.getGroup().getId());
    //    }
    //
    //    // 用户消息关联关系
    //    var userMessageRecords = new UserMessageRecord[uids.size()];
    //    for (int i = 0; i < uids.size(); i++) {
    //      userMessageRecords[i] =
    //          new UserMessageRecord().setUid(uids.get(i)).setMessageId(entity.getId());
    //    }
    //
    //    return Mono.from(
    //            dsl.insertInto(MESSAGE).set(record)
    //            //
    //            )
    //        .then(
    //            Mono.from(dsl.batchInsert(userMessageRecords))
    //            //
    //            )
    //        .then();
    // FIXME
    return Mono.empty();
  }

  @Override
  public Mono<Void> updateUnreadStatus(long uid, List<String> messageIds, int v) {
    // FIXME 完善
    //    dsl.update(MESSAGE).set(MESSAGE.UNREAD, v)
    return null;
  }

  @Override
  public Mono<Msg> queryById(String id) {
    return Mono.from(
            dsl.selectFrom(MESSAGE).where(MESSAGE.ID.eq(id))
            //
            )
        .map(MessageRecordMapper.INSTANCE::map);
  }

  @Override
  public Flux<Msg> queryByUser(UserMessageQuery q, Paging paging) {
    return Flux.from(
            dsl.select(MESSAGE.fields())
                .from(USER_MESSAGE)
                .leftJoin(MESSAGE)
                .on(USER_MESSAGE.MESSAGE_ID.eq(MESSAGE.ID))
                .where(USER_MESSAGE.UID.eq(q.getUid()))
            //
            )
        .map(r -> MessageRecordMapper.INSTANCE.map(r.into(MESSAGE)));
  }
}
