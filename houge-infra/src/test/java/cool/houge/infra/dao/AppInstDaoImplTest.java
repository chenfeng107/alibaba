package cool.houge.infra.dao;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import cool.houge.domain.model.AppInst;
import cool.houge.util.HostNameUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/** @author KK (kzou227@qq.com) */
class AppInstDaoImplTest extends AbstractTestDao {

  AppInstDaoImpl appInstDao;

  @BeforeEach
  void setup() {
    this.appInstDao = new AppInstDaoImpl(super.rc);
  }

  @Test
  void insert() {
    var m = newModel();
    txOps.tx(appInstDao.insert(m)).as(StepVerifier::create).expectNext(1).expectComplete().verify();
  }

  @Test
  void delete() {
    var m = newModel();
    txOps
        .tx(appInstDao.insert(m).then(appInstDao.delete(m.getId())))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        .verify();
  }

  @Test
  void deleteNonexistentData() {
    txOps
        .tx(appInstDao.delete(Integer.MIN_VALUE))
        .as(StepVerifier::create)
        .expectNext(0)
        .expectComplete()
        .verify();
  }

  @Test
  void updateCheckTime() {
    var m = newModel();
    txOps
        .tx(appInstDao.insert(m).then(appInstDao.updateCheckTime(m.getId())))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        .verify();
  }

  @Test
  void updateCheckTimeNonexistentData() {
    txOps
        .tx(appInstDao.updateCheckTime(Integer.MIN_VALUE))
        .as(StepVerifier::create)
        .expectNext(0)
        .expectComplete()
        .verify();
  }

  @Test
  void findById() {
    var m = newModel();
    txOps
        .tx(appInstDao.insert(m).then(appInstDao.findById(m.getId())))
        .as(StepVerifier::create)
        .assertNext(
            o ->
                assertSoftly(
                    s -> {
                      s.assertThat(o.getId()).as("id").isEqualTo(m.getId());
                      s.assertThat(o.getAppName()).as("appName").isEqualTo(m.getAppName());
                      s.assertThat(o.getHostName()).as("hostName").isEqualTo(m.getHostName());
                      s.assertThat(o.getHostAddress())
                          .as("hostAddress")
                          .isEqualTo(m.getHostAddress());
                      s.assertThat(o.getOsName()).as("osName").isEqualTo(m.getOsName());
                      s.assertThat(o.getOsVersion()).as("osVersion").isEqualTo(m.getOsVersion());
                      s.assertThat(o.getOsUser()).as("osUser").isEqualTo(m.getOsUser());
                      s.assertThat(o.getJavaVmName()).as("javaVmName").isEqualTo(m.getJavaVmName());
                      s.assertThat(o.getJavaVmVersion())
                          .as("javaVmVersion")
                          .isEqualTo(m.getJavaVmVersion());
                      s.assertThat(o.getJavaVmVendor())
                          .as("javaVmVendor")
                          .isEqualTo(m.getJavaVmVendor());
                      s.assertThat(o.getWorkDir()).as("workDir").isEqualTo(m.getWorkDir());
                      s.assertThat(o.getPid()).as("pid").isEqualTo(m.getPid());
                      s.assertThat(o.getCreateTime()).as("createTime").isAfter(LocalDateTime.MIN);
                      s.assertThat(o.getCheckTime()).as("checkTime").isAfter(LocalDateTime.MIN);
                    }))
        .expectComplete()
        .verify();
  }

  @Test
  void findByIdNonexistentData() {
    appInstDao.findById(Integer.MIN_VALUE).as(StepVerifier::create).expectComplete().verify();
  }

  AppInst newModel() {
    InetAddress hostAddr;
    try {
      hostAddr = HostNameUtils.getLocalHostLANAddress();
    } catch (UnknownHostException e) {
      throw new IllegalArgumentException(e);
    }
    var m = new AppInst();
    m.setId(FAKER_CN.random().nextInt(7000000, 7777777));
    m.setAppName("junit-test");
    m.setHostName(hostAddr.getHostName());
    m.setHostAddress(hostAddr.getHostAddress());
    m.setOsName(System.getProperty("os.name"));
    m.setOsVersion(System.getProperty("os.version"));
    m.setOsUser(System.getProperty("user.name"));
    m.setJavaVmName(System.getProperty("java.vm.name"));
    m.setJavaVmVersion(System.getProperty("java.vm.version"));
    m.setJavaVmVendor(System.getProperty("java.vm.vendor"));
    m.setWorkDir(System.getProperty("user.dir"));
    m.setPid(ProcessHandle.current().pid());
    return m;
  }
}
