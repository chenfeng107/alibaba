package cool.houge.domain.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群组消息.
 *
 * @author KK (kzou227@qq.com)
 */
@Data
@Accessors(chain = true)
public class GroupMsg {

  /** 消息 ID. */
  private String id;
  /** 发送人. */
  private User send;
  /** 接收群组. */
  private Group group;
  /** 消息内容. */
  private String content;
  /**
   * 消息内容类型.
   *
   * <ul>
   *   <li>{@code 1}: 普通文本消息
   *   <li>{@code 2}: 图片消息
   *   <li>{@code 3}: 音频消息
   *   <li>{@code 4}: 视频消息
   * </ul>
   */
  private Integer contentType;
  /** 扩展参数. */
  private String extra;
  /** 创建时间. */
  private LocalDateTime createTime;
  /** 更新时间. */
  private LocalDateTime updateTime;
}
