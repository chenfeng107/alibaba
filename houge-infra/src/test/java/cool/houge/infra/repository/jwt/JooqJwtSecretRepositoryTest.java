package cool.houge.infra.repository.jwt;

import static cool.houge.infra.db.Tables.JWT_SECRET;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import cool.houge.domain.model.JwtSecret;
import cool.houge.infra.db.tables.records.JwtSecretRecord;
import cool.houge.infra.repository.JooqTestBase;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * {@link JooqJwtSecretRepository}.
 *
 * @author KK (kzou227@qq.com)
 */
class JooqJwtSecretRepositoryTest extends JooqTestBase {

  JooqJwtSecretRepository repos;

  @BeforeEach
  void beforeEach() {
    this.repos = new JooqJwtSecretRepository(dsl);
  }

  @Test
  void insert() {
    var model = new JwtSecret();
    model.setId("TEST-" + faker.random().hex(3));
    model.setAlgorithm("HS512");
    model.setSecretKey(faker.random().hex(128).getBytes(StandardCharsets.UTF_8));

    var p = repos.insert(model);
    StepVerifier.create(p).expectComplete().verify();

    // 清理数据
    this.clean(model.getId());
  }

  @Test
  void delete() {
    var record = new JwtSecretRecord();
    record.setId("TEST-" + faker.random().hex(3));
    record.setAlgorithm("HS512");
    record.setSecretKey(faker.random().hex(128).getBytes(StandardCharsets.UTF_8));

    // 插入数据
    StepVerifier.create(dsl.insertInto(JWT_SECRET).set(record))
        .expectNext(1)
        .expectComplete()
        .verify();

    // 删除数据
    var p = repos.delete(record.getId());
    StepVerifier.create(p).expectComplete().verify();

    // 校验数据库是否还存在数据
    StepVerifier.create(
            Mono.from(
                dsl.selectFrom(JWT_SECRET).where(JWT_SECRET.ID.eq(record.getId()))
                //
                )
            //
            )
        .expectComplete()
        .verify();
  }

  @Test
  void findById() {
    var record = new JwtSecretRecord();
    record.setId("TEST-" + faker.random().hex(3));
    record.setAlgorithm("HS512");
    record.setSecretKey(faker.random().hex(128).getBytes(StandardCharsets.UTF_8));

    // 插入数据
    StepVerifier.create(dsl.insertInto(JWT_SECRET).set(record))
        .expectNext(1)
        .expectComplete()
        .verify();

    var p = repos.findById(record.getId());
    StepVerifier.create(p)
        .assertNext(
            jwtSecret ->
                assertSoftly(
                    s -> {
                      s.assertThat(jwtSecret.getId()).isEqualTo(record.getId());
                      s.assertThat(jwtSecret.getAlgorithm()).isEqualTo(record.getAlgorithm());
                      s.assertThat(jwtSecret.getSecretKey()).isEqualTo(record.getSecretKey());
                      s.assertThat(jwtSecret.getCreateTime()).isNotNull();
                      s.assertThat(jwtSecret.getUpdateTime()).isNotNull();
                    })
            //
            )
        .expectComplete()
        .verify();

    // 清理数据
    clean(record.getId());
  }

  @Test
  void findAll() {
    // FIXME 完善
  }

  void clean(String id) {
    StepVerifier.create(
            Mono.from(
                dsl.delete(JWT_SECRET).where(JWT_SECRET.ID.eq(id))
                //
                ))
        .expectNext(1)
        .expectComplete()
        .verify();
  }
}
