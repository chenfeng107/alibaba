package cool.houge.ws;

/**
 * 错误码定义.
 *
 * @author KK (kzou227@qq.com)
 */
public interface ErrorCodes {

  /** 未知的错误. */
  int UNKNOWN = -1;
  /** 消息包错误. */
  int PACKET = 70;
  /** gRPC响应的错误. */
  int GRPC = 80;
}
