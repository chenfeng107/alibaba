package cool.houge.infra.dao;

import cool.houge.domain.model.UserMsg;
import cool.houge.domain.msg.UserMsgDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import java.util.List;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class UserMsgDaoImpl implements UserMsgDao {

  private final String INSERT_SQL =
      "INSERT INTO t_user_msg(id,send_uid,rec_uid,content,content_type,extra) VALUES($1,$2,$3,$4,$5,$6)";
  private final String UPDATE_UNREAD_SQL =
      "UPDATE t_user_msg SET unread=$1,update_time=NOW() WHERE id IN ($2)";

  private final R2dbcClient rc;

  public @Inject UserMsgDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(UserMsg msg) {
    return rc.use(
            spec ->
                spec.sql(INSERT_SQL)
                    .bind("$1", msg.getId())
                    .bind("$2", msg.getSend().getId())
                    .bind("$3", msg.getRec().getId())
                    .bind("$4", msg.getContent())
                    .bind("$5", msg.getContentType())
                    .bind("$6", msg.getExtra(), String.class)
                    .rowsUpdated())
        .single();
  }

  @Override
  public Mono<Integer> updateUnread(List<String> ids) {
    return rc.use(spec -> spec.sql(UPDATE_UNREAD_SQL).bind("$1", 1).bind("$2", ids).rowsUpdated())
        .single();
  }
}
