package cool.houge.infra.repository.message;

import com.google.common.base.Joiner;
import cool.houge.domain.Paging;
import cool.houge.domain.model.Message;
import cool.houge.domain.repository.message.MessageQueryRepository;
import cool.houge.domain.repository.message.MessageRepository;
import cool.houge.domain.repository.message.UserMessageQuery;
import cool.houge.r2dbc.Parameter;
import cool.houge.r2dbc.R2dbcClient;
import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PostgreMessageRepository implements MessageRepository, MessageQueryRepository {

  private static final String INSERT_SQL =
      "INSERT INTO messages("
          + "id,sender_id,receiver_id,group_id,kind,content,content_type,extra_args,create_time,update_time)"
          + " VALUES($1,$2,$3,$4,$5,$6,$7,$8,now(),now())";
  private static final String UPDATE_UNREAD_STATUS_SQL =
      "UPDATE messages SET unread=$1,update_time=now() WHERE id = ANY(string_to_array($2,',')) AND receiver_id=$3";

  private static final String QUERY_BY_ID_SQL = "SELECT * FROM messages WHERE id=$1";
  private static final String QUERY_BY_USER_SQL =
      "SELECT b.* FROM"
          + " user_messages a LEFT JOIN messages b ON a.message_id = b.id"
          + " WHERE a.uid=$1 AND b.create_time>=$2"
          + " OFFSET $3 LIMIT $4";

  private final R2dbcClient rc;

  /**
   * 使用 R2DBC 客户端构造对象.
   *
   * @param rc R2DBC 客户端
   */
  @Inject
  public PostgreMessageRepository(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Void> insert(Message entity, List<Long> uids) {
    if (uids == null || uids.isEmpty()) {
      throw new IllegalArgumentException("[uids]不能为NULL或者EMPTY");
    }

    var sql = new StringBuilder(128 * uids.size());
    for (Long uid : uids) {
      if (uid == null) {
        throw new IllegalArgumentException(
            "正将消息[id:" + entity.getId() + "]与NULL关联 - uids: " + Arrays.toString(uids.toArray()));
      }

      sql.append("INSERT INTO user_messages(uid,message_id) VALUES(")
          .append(uid)
          .append(",'")
          .append(entity.getId())
          .append("'")
          .append(");");
    }
    return Mono.when(insert0(entity), rc.batchSql(sql.toString()).rowsUpdated());
  }

  @Override
  public Mono<Void> updateUnreadStatus(long uid, List<String> messageIds, int v) {
    return rc.sql(UPDATE_UNREAD_STATUS_SQL)
        .bind(new Object[] {v, Joiner.on(',').join(messageIds), uid})
        .rowsUpdated()
        .then();
  }

  @Override
  public Mono<Message> queryById(String id) {
    return rc.sql(QUERY_BY_ID_SQL).bind(0, id).map(this::mapToEntity).one();
  }

  @Override
  public Flux<Message> queryByUser(UserMessageQuery q, Paging paging) {
    return rc.sql(QUERY_BY_USER_SQL)
        .bind(new Object[] {q.getUid(), q.getBeginTime(), paging.getOffset(), paging.getLimit()})
        .map(this::mapToEntity)
        .all();
  }

  private Message mapToEntity(Row row) {
    var e = new Message();
    e.setId(row.get("id", String.class));
    // FIXME 完善
    //    e.setSenderId(row.get("sender_id", Long.class));
    //    e.setReceiverId(row.get("receiver_id", Long.class));
    //    e.setGroupId(row.get("group_id", Long.class));
    e.setKind(row.get("kind", Integer.class));
    e.setContent(row.get("content", String.class));
    e.setContentType(row.get("content_type", Integer.class));
    e.setExtraArgs(row.get("extra_args", String.class));
    e.setUnread(row.get("unread", Integer.class));
    e.setCreateTime(row.get("create_time", LocalDateTime.class));
    e.setUpdateTime(row.get("update_time", LocalDateTime.class));
    return e;
  }

  private Mono<Integer> insert0(Message entity) {
    return rc.sql(INSERT_SQL)
        .bind(
            new Object[] {
              entity.getId(),
              Parameter.fromOrNull(entity.getSender().getId(), Long.class),
              Parameter.fromOrNull(entity.getReceiver().getId(), Long.class),
              Parameter.fromOrNull(entity.getGroup().getId(), Long.class),
              Parameter.fromOrNull(entity.getKind(), Integer.class),
              entity.getContent(),
              entity.getContentType(),
              Parameter.fromOrNull(entity.getExtraArgs(), String.class)
            })
        .rowsUpdated();
  }
}
