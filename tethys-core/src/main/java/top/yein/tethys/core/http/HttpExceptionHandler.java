package top.yein.tethys.core.http;

import com.google.common.collect.ImmutableMap;
import io.netty.handler.codec.http.HttpResponseStatus;
import java.util.Arrays;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import top.yein.chaos.biz.BizCodeException;
import top.yein.tethys.core.Env;
import top.yein.tethys.domain.Problem;

/**
 * HTTP REST 异常处理器.
 *
 * @author KK (kzou227@qq.com)
 */
@Log4j2
public class HttpExceptionHandler extends AbstractRestSupport {

  /**
   * 应用处理器.
   *
   * @param request 请求对象
   * @param response 响应对象
   * @param t 异常对象
   * @return RS
   */
  public Mono<Void> apply(HttpServerRequest request, HttpServerResponse response, Throwable t) {
    var problemBuilder = Problem.builder();
    var propertiesBuilder = ImmutableMap.<String, Object>builder();
    boolean errorLog;
    if (t instanceof BizCodeException) {
      var ex = (BizCodeException) t;
      var bc = ex.getBizCode();
      problemBuilder
          .status(bc.getStatus())
          .code(bc.getCode())
          .title(ex.getRawMessage())
          .detail(ex.getMessage());
      propertiesBuilder.put("context_values", ex.getContextEntries());
      errorLog = bc.getStatus() >= HttpResponseStatus.INTERNAL_SERVER_ERROR.code();
    } else {
      problemBuilder.status(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()).title(t.getMessage());
      errorLog = true;
    }

    // 是否打印 DEBUG 日志
    var debug = Env.current() != Env.PROD || queryParam(request, "debug") != null;
    if (errorLog) {
      // 服务器内部错误需要记录 ERROR 日志
      log.error("服务器内部异常 uri={}", request.uri(), t);
    } else if (debug) {
      // debug 模式下将异常错误信息记录为 DEBUG 日志
      log.debug("请求错误 uri={}", request.uri(), t);
    }

    if (debug) {
      // debug 模式下将异常堆栈输出至客户端
      var stacktrace =
          Arrays.stream(t.getStackTrace()).map(String::valueOf).collect(Collectors.toList());
      propertiesBuilder.put("stacktrace", stacktrace);
    }

    var properties = propertiesBuilder.build();
    if (!properties.isEmpty()) {
      problemBuilder.properties(properties);
    }
    var problem = problemBuilder.build();

    // 设置 HTTP 错误状态码
    response.status(problem.getStatus());
    return json(response, problem);
  }
}