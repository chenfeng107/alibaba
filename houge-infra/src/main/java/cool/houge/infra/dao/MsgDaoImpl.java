package cool.houge.infra.dao;

import com.google.common.base.Joiner;
import cool.houge.domain.model.Msg;
import cool.houge.domain.msg.MsgDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class MsgDaoImpl implements MsgDao {

  private final R2dbcClient rc;

  public @Inject MsgDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Void> insert(Msg msg, Set<Integer> uids) {
    return Mono.when(insert(msg), insertUserMsg(msg.getId(), uids));
  }

  @Override
  public Mono<Integer> updateUnread(List<String> ids) {
    return rc.use(
            spec ->
                spec.sql("UPDATE t_msg SET unread=?unread,update_time=NOW() WHERE id IN (?ids)")
                    .bind("unread", 1)
                    .bind("ids", Joiner.on(',').join(ids))
                    .rowsUpdated())
        .single();
  }

  Mono<Integer> insert(Msg m) {
    return rc.use(
            spec ->
                spec.sql(
                        "INSERT INTO t_msg(id,sender_id,receiver_id,group_id,kind,content,content_type,extra)"
                            + " values(?id,?sender_id,?receiver_id,?group_id,?kind,?content,?content_type,?extra)")
                    .bind("id", m.getId())
                    .bind("sender_id", m.getSender().getId())
                    .bind(
                        "receiver_id",
                        m.getReceiver() != null ? m.getReceiver().getId() : null,
                        Integer.class)
                    .bind(
                        "group_id",
                        m.getGroup() != null ? m.getGroup().getId() : null,
                        Integer.class)
                    .bind("kind", m.getKind())
                    .bind("content", m.getContent())
                    .bind("content_type", m.getContentType())
                    .bind("extra", m.getExtra())
                    .rowsUpdated())
        .single();
  }

  Mono<Integer> insertUserMsg(String id, Set<Integer> uids) {
    var sql = new StringBuilder(128 * uids.size());
    for (Integer uid : uids) {
      if (uid == null) {
        throw new IllegalArgumentException(
            "正将消息[id:" + id + "]与NULL关联 - uids: " + Arrays.toString(uids.toArray()));
      }

      sql.append("INSERT INTO user_t_msg(uid,msg_id) VALUES(")
          .append(uid)
          .append(",'")
          .append(uid)
          .append("'")
          .append(");");
    }
    return rc.use(spec -> spec.sql(sql.toString()).rowsUpdated()).single();
  }
}
