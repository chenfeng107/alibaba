package cool.houge.rest.web;

import lombok.Builder;
import lombok.Value;

/**
 * 响应结果.
 *
 * @author KK (kzou227@qq.com)
 */
@Value
public class ErrorResult {

  /** 错误详情. */
  private Error error;

  @Value
  @Builder
  public static class Error {

    /** 错误码. */
    private int code;
    /** HTTP Status. */
    private int status;
    /** 错误信息. */
    private String message;
    /** 开发发者消息. */
    private String developerMessage;
    /** 详细. */
    private Object details;
    /** 堆栈. */
    private Object stacktrace;
  }
}
