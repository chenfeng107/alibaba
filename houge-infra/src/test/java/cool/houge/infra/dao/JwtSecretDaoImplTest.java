package cool.houge.infra.dao;

import cool.houge.domain.model.JwtSecret;
import java.nio.charset.StandardCharsets;
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
  void delete() {
    var m = newModel();
    txOps
        .tx(dao.insert(m).then(dao.delete(m.getId())))
        .as(StepVerifier::create)
        .expectNext(1)
        .expectComplete()
        .verify();
  }

  @Test
  void deleteNonexistentData() {
    txOps
        .tx(dao.delete(UUID.randomUUID().toString()))
        .as(StepVerifier::create)
        .expectNext(0)
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
