package cool.houge.infra.repository.system;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import cool.houge.domain.model.AppInst;
import cool.houge.infra.db.Tables;
import cool.houge.infra.repository.JooqTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * {@link JooqServerInstanceRepository}.
 *
 * @author KK (kzou227@qq.com)
 */
class JooqAppInstRepositoryTest extends JooqTestBase {

  JooqServerInstanceRepository repos;

  @BeforeEach
  void beforeEach() {
    this.repos = new JooqServerInstanceRepository(dsl);
  }

  @Test
  void insert() {
    var model =
        new AppInst()
            .setId((int) faker.random().nextLong())
            .setAppName("JUnit-Test")
            .setHostName("local")
            .setHostAddress("127.0.0.1")
            .setOsName("Linux")
            .setOsVersion("5.1")
            .setOsArch("x86_64")
            .setOsUser("root")
            .setJavaVmName("OpenJDK")
            .setJavaVmVersion("11")
            .setJavaVmVendor("Oracle")
            .setWorkDir(System.getProperty("user.dir"))
            .setPid(ProcessHandle.current().pid());
    var p = repos.insert(model);
    StepVerifier.create(p).expectComplete().verify();

    // 清理数据
    this.clean(model.getId());
  }

  @Test
  void delete() {
    var model =
        new AppInst()
            .setId((int) faker.random().nextLong())
            .setAppName("JUnit-Test")
            .setHostName("local")
            .setHostAddress("127.0.0.1")
            .setOsName("Linux")
            .setOsVersion("5.1")
            .setOsArch("x86_64")
            .setOsUser("root")
            .setJavaVmName("OpenJDK")
            .setJavaVmVersion("11")
            .setJavaVmVendor("Oracle")
            .setWorkDir(System.getProperty("user.dir"))
            .setPid(ProcessHandle.current().pid());
    var p = repos.insert(model).then(repos.delete(model.getId()));
    StepVerifier.create(p).expectComplete().verify();
  }

  @Test
  void updateCheckTime() {
    var model =
        new AppInst()
            .setId((int) faker.random().nextLong())
            .setAppName("JUnit-Test")
            .setHostName("local")
            .setHostAddress("127.0.0.1")
            .setOsName("Linux")
            .setOsVersion("5.1")
            .setOsArch("x86_64")
            .setOsUser("root")
            .setJavaVmName("OpenJDK")
            .setJavaVmVersion("11")
            .setJavaVmVendor("Oracle")
            .setWorkDir(System.getProperty("user.dir"))
            .setPid(ProcessHandle.current().pid());
    var p = repos.insert(model).then(repos.updateCheckTime(model.getId()));
    StepVerifier.create(p).expectComplete().verify();

    // 清理数据
    clean(model.getId());
  }

  @Test
  void findById() {
    var model =
        new AppInst()
            .setId((int) faker.random().nextLong())
            .setAppName("JUnit-Test")
            .setHostName("local")
            .setHostAddress("127.0.0.1")
            .setOsName("Linux")
            .setOsVersion("5.1")
            .setOsArch("x86_64")
            .setOsUser("root")
            .setJavaVmName("OpenJDK")
            .setJavaVmVersion("11")
            .setJavaVmVendor("Oracle")
            .setWorkDir(System.getProperty("user.dir"))
            .setPid(ProcessHandle.current().pid());
    var p = repos.insert(model).then(repos.findById(model.getId()));
    StepVerifier.create(p)
        .assertNext(
            dbModel ->
                assertSoftly(
                    s -> {
                      s.assertThat(dbModel.getId()).isEqualTo(model.getId());
                      s.assertThat(dbModel.getAppName()).isEqualTo(model.getAppName());
                      s.assertThat(dbModel.getHostName()).isEqualTo(model.getHostName());
                      s.assertThat(dbModel.getHostAddress()).isEqualTo(model.getHostAddress());
                      s.assertThat(dbModel.getOsName()).isEqualTo(model.getOsName());
                      s.assertThat(dbModel.getOsVersion()).isEqualTo(model.getOsVersion());
                      s.assertThat(dbModel.getOsArch()).isEqualTo(model.getOsArch());
                      s.assertThat(dbModel.getOsUser()).isEqualTo(model.getOsUser());
                      s.assertThat(dbModel.getJavaVmName()).isEqualTo(model.getJavaVmName());
                      s.assertThat(dbModel.getJavaVmVersion()).isEqualTo(model.getJavaVmVersion());
                      s.assertThat(dbModel.getJavaVmVendor()).isEqualTo(model.getJavaVmVendor());
                      s.assertThat(dbModel.getWorkDir()).isEqualTo(model.getWorkDir());
                      s.assertThat(dbModel.getPid()).isEqualTo(model.getPid());
                      s.assertThat(dbModel.getCreateTime()).isNotNull();
                      s.assertThat(dbModel.getCheckTime()).isNotNull();
                    })
            //
            )
        .expectComplete()
        .verify();

    // 清理数据
    clean(model.getId());
  }

  void clean(int id) {
    StepVerifier.create(
            Mono.from(
                dsl.delete(Tables.SERVER_INSTANCE).where(Tables.SERVER_INSTANCE.ID.eq(id))
                //
                ))
        .expectNext(1)
        .expectComplete()
        .verify();
  }
}
