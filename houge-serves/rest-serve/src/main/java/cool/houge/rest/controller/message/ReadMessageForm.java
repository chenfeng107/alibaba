package cool.houge.rest.controller.message;

import java.util.Set;
import lombok.Builder;
import lombok.Value;

/** @author KK (kzou227@qq.com) */
@Value
@Builder
public class ReadMessageForm {

  private Set<String> msgIds;
}
