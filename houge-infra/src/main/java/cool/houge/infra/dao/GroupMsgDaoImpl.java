package cool.houge.infra.dao;

import cool.houge.domain.model.GroupMsg;
import cool.houge.domain.msg.GroupMsgDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class GroupMsgDaoImpl implements GroupMsgDao {

  private final String INSERT_SQL =
      "INSERT INTO t_group_msg(id,send_uid,group_id,content,content_type,extra) VALUES($1,$2,$3,$4,$5,$6)";

  private final R2dbcClient rc;

  public @Inject GroupMsgDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(GroupMsg msg) {
    return rc.use(
            spec ->
                spec.sql(INSERT_SQL)
                    .bind("$1", msg.getId())
                    .bind("$2", msg.getSend().getId())
                    .bind("$3", msg.getGroup().getId())
                    .bind("$4", msg.getContent())
                    .bind("$5", msg.getContentType())
                    .bind("$6", msg.getExtra(), String.class)
                    .rowsUpdated())
        .single();
  }
}
