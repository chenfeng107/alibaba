package cool.houge.infra.dao;

import cool.houge.domain.model.AppInst;
import cool.houge.domain.system.AppInstDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class AppInstDaoImpl implements AppInstDao {

  private final String INSERT_SQL =
      "INSERT INTO t_app_inst(id,app_name,host_name,host_address,os_name,os_version,os_user,java_vm_name,java_vm_version,java_vm_vendor,work_dir,pid)"
          + "VALUES($1,$2,$3,$4,$5,$6,$7,$8,$9,$10,$11,$12)";
  private final String DELETE_SQL = "DELETE FROM t_app_inst WHERE id=$1";
  private final String UPDATE_CHECK_TIME_SQL = "UPDATE t_app_inst SET check_time=now() WHERE id=$1";
  private final String GET_SQL = "SELECT * FROM t_app_inst WHERE id=$1";

  private final R2dbcClient rc;

  public @Inject AppInstDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(AppInst m) {
    return rc.use(
            spec ->
                spec.sql(INSERT_SQL)
                    .bind("$1", m.getId())
                    .bind("$2", m.getAppName())
                    .bind("$3", m.getHostName())
                    .bind("$4", m.getHostAddress())
                    .bind("$5", m.getOsName())
                    .bind("$6", m.getOsVersion())
                    .bind("$7", m.getOsUser())
                    .bind("$8", m.getJavaVmName())
                    .bind("$9", m.getJavaVmVersion())
                    .bind("$10", m.getJavaVmVendor())
                    .bind("$11", m.getWorkDir())
                    .bind("$12", m.getPid())
                    .rowsUpdated())
        .single();
  }

  @Override
  public Mono<Integer> delete(int id) {
    return rc.use(spec -> spec.sql(DELETE_SQL).bind("$1", id).rowsUpdated()).single();
  }

  @Override
  public Mono<Integer> updateCheckTime(int id) {
    return rc.use(spec -> spec.sql(UPDATE_CHECK_TIME_SQL).bind("$1", id).rowsUpdated()).single();
  }

  @Override
  public Mono<AppInst> get(int id) {
    return rc.use(spec -> spec.sql(GET_SQL).bind("$1", id).fetch(this::mapEntity)).singleOrEmpty();
  }

  private AppInst mapEntity(Row row) {
    var e = new AppInst();
    e.setId(row.get("id", Integer.class));
    e.setAppName(row.get("app_name", String.class));
    e.setHostName(row.get("host_name", String.class));
    e.setHostAddress(row.get("host_address", String.class));
    e.setOsName(row.get("os_name", String.class));
    e.setOsVersion(row.get("os_version", String.class));
    e.setOsUser(row.get("os_user", String.class));
    e.setJavaVmName(row.get("java_vm_name", String.class));
    e.setJavaVmVersion(row.get("java_vm_version", String.class));
    e.setJavaVmVendor(row.get("java_vm_vendor", String.class));
    e.setWorkDir(row.get("work_dir", String.class));
    e.setPid(row.get("pid", Long.class));
    e.setVer(row.get("ver", Integer.class));
    e.setCreateTime(row.get("create_time", LocalDateTime.class));
    e.setCheckTime(row.get("check_time", LocalDateTime.class));
    return e;
  }
}
