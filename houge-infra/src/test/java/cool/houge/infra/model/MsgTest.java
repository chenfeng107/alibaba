package cool.houge.infra.model;

import static org.assertj.core.api.Assertions.assertThat;

import cool.houge.domain.model.Msg;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/** @author KK (kzou227@qq.com) */
class MsgTest {

  @Nested
  class ContentTypeTest {

    @Test
    void forCode() {
      for (Msg.ContentType value : Msg.ContentType.values()) {
        assertThat(Msg.ContentType.forCode(value.getCode())).isEqualTo(value);
      }
      assertThat(Msg.ContentType.forCode(null)).isEqualTo(Msg.ContentType.UNRECOGNIZED);
      assertThat(Msg.ContentType.forCode(9999)).isEqualTo(Msg.ContentType.UNRECOGNIZED);
    }
  }

  @Nested
  class KindTest {

    @Test
    void forCode() {
      for (Msg.Kind value : Msg.Kind.values()) {
        assertThat(Msg.Kind.forCode(value.getCode())).isEqualTo(value);
      }
      assertThat(Msg.Kind.forCode(null)).isEqualTo(Msg.Kind.UNRECOGNIZED);
      assertThat(Msg.Kind.forCode(9999)).isEqualTo(Msg.Kind.UNRECOGNIZED);
    }
  }

  @Nested
  class ReadStatusTest {

    @Test
    void forCode() {
      for (Msg.ReadStatus value : Msg.ReadStatus.values()) {
        assertThat(Msg.ReadStatus.forCode(value.getCode())).isEqualTo(value);
      }
      assertThat(Msg.ReadStatus.forCode(null)).isEqualTo(Msg.ReadStatus.UNRECOGNIZED);
      assertThat(Msg.ReadStatus.forCode(9999)).isEqualTo(Msg.ReadStatus.UNRECOGNIZED);
    }
  }
}
