package cool.houge.infra.dao;

import cool.houge.domain.model.AppInst;
import cool.houge.domain.system.AppInstDao;
import cool.houge.infra.r2dbc.R2dbcClient;
import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class AppInstDaoImpl implements AppInstDao {

  private final R2dbcClient rc;

  public AppInstDaoImpl(R2dbcClient rc) {
    this.rc = rc;
  }

  @Override
  public Mono<Integer> insert(AppInst m) {
    return rc.use(
            spec ->
                spec.sql(
                        "INSERT INTO t_app_inst(id,app_name,host_name,host_address,os_name,os_version,os_user,java_vm_name,java_vm_version,java_vm_vendor,work_dir,pid)"
                            + "values(?id,?app_name,?host_name,?host_address,?os_name,?os_version,?os_user,?java_vm_name,?java_vm_version,?java_vm_vendor,?work_dir,?pid)")
                    .bind("id", m.getId())
                    .bind("app_name", m.getAppName())
                    .bind("host_name", m.getHostName())
                    .bind("host_address", m.getHostAddress())
                    .bind("os_name", m.getOsName())
                    .bind("os_version", m.getOsVersion())
                    .bind("os_user", m.getOsUser())
                    .bind("java_vm_name", m.getJavaVmName())
                    .bind("java_vm_version", m.getJavaVmVersion())
                    .bind("java_vm_vendor", m.getJavaVmVendor())
                    .bind("work_dir", m.getWorkDir())
                    .bind("pid", m.getPid())
                    .rowsUpdated())
        .single();
  }

  @Override
  public Mono<Integer> delete(int id) {
    return rc.use(
            spec -> spec.sql("delete from t_app_inst where id=?id").bind("id", id).rowsUpdated())
        .single();
  }

  @Override
  public Mono<Integer> updateCheckTime(int id) {
    return rc.use(
            spec ->
                spec.sql("update t_app_inst set check_time=now() where id=?id")
                    .bind("id", id)
                    .rowsUpdated())
        .singleOrEmpty();
  }

  @Override
  public Mono<AppInst> findById(int id) {
    return rc.use(
            spec ->
                spec.sql("select * from t_app_inst where id=?id")
                    .bind("id", id)
                    .fetch(this::mapEntity))
        .singleOrEmpty();
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
