package cool.houge.infra.repository.system;

import cool.houge.domain.model.ServerInstance;
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
class JooqServerInstanceRepositoryTest extends JooqTestBase {

  JooqServerInstanceRepository repos;

  @BeforeEach
  void beforeEach() {
    this.repos = new JooqServerInstanceRepository(dsl);
  }

  @Test
  void insert() {
    var model =
        new ServerInstance()
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
