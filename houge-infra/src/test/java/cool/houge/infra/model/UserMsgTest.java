package cool.houge.infra.model;

import static org.assertj.core.api.Assertions.assertThat;

import cool.houge.domain.model.MsgContentType;
import cool.houge.domain.model.UserMsg;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/** @author KK (kzou227@qq.com) */
class UserMsgTest {

  @Nested
  class ContentTypeTest {

    @Test
    void forCode() {
      for (MsgContentType value : MsgContentType.values()) {
        assertThat(MsgContentType.forCode(value.getCode())).isEqualTo(value);
      }
      assertThat(MsgContentType.forCode(null)).isEqualTo(MsgContentType.UNRECOGNIZED);
      assertThat(MsgContentType.forCode(9999)).isEqualTo(MsgContentType.UNRECOGNIZED);
    }
  }

  @Nested
  class ReadStatusTest {

    @Test
    void forCode() {
      for (UserMsg.ReadStatus value : UserMsg.ReadStatus.values()) {
        assertThat(UserMsg.ReadStatus.forCode(value.getCode())).isEqualTo(value);
      }
      assertThat(UserMsg.ReadStatus.forCode(null)).isEqualTo(UserMsg.ReadStatus.UNRECOGNIZED);
      assertThat(UserMsg.ReadStatus.forCode(9999)).isEqualTo(UserMsg.ReadStatus.UNRECOGNIZED);
    }
  }
}
