package cool.houge.infra.dao;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import cool.houge.domain.model.JwtSecret;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/** @author KK (kzou227@qq.com) */
class JwtSecretDaoImplTest extends AbstractTestDao {

  JwtSecretDaoImpl dao;

  @BeforeEach
  void setup() {
    this.dao = new JwtSecretDaoImpl(super.rc);
  }

  @Test
  void insert() {
    var m = newModel();
    txOps
        .tx(dao.insert(m))
        //
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        .verify();
  }

  @Test
  void remove() {
    var m = newModel();
    txOps
        .tx(dao.insert(m).then(dao.remove(m.getId())))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        .verify();
  }

  @Test
  void removeNonexistentData() {
    txOps
        .tx(dao.remove(UUID.randomUUID().toString()))
        .as(StepVerifier::create)
        .expectNext(0)
        .expectComplete()
        .verify();
  }

  @Test
  void get() {
    var m = newModel();
    txOps
        .tx(dao.insert(m).then(dao.get(m.getId())))
        .as(StepVerifier::create)
        .assertNext(
            o ->
                assertSoftly(
                    s -> {
                      s.assertThat(o.getId()).as("id").isEqualTo(m.getId());
                      s.assertThat(o.getSecret()).as("secret").isEqualTo(m.getSecret());
                      s.assertThat(o.getDeleted()).as("deleted").isEqualTo(0);
                      s.assertThat(o.getCreateTime()).as("createTime").isAfter(LocalDateTime.MIN);
                      s.assertThat(o.getUpdateTime()).as("updateTime").isAfter(LocalDateTime.MIN);
                    }))
        .expectComplete()
        .verify();
  }

  @Test
  void getNonexistentData() {
    txOps
        .tx(dao.get(UUID.randomUUID().toString()))
        .as(StepVerifier::create)
        .expectComplete()
        .verify();
  }

  JwtSecret newModel() {
    var m = new JwtSecret();
    m.setId(FAKER_CN.random().hex());
    m.setAlgorithm("HS512");
    m.setSecret(FAKER_CN.random().hex(256).getBytes(StandardCharsets.UTF_8));
    return m;
  }
}
