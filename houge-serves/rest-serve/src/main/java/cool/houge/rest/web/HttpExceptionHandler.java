/*
 * Copyright 2019-2021 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cool.houge.rest.web;

import am.ik.yavi.core.ConstraintViolation;
import am.ik.yavi.core.ConstraintViolationsException;
import com.google.common.base.Strings;
import com.google.protobuf.InvalidProtocolBufferException;
import cool.houge.Env;
import cool.houge.protos.ErrorInfo;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.netty.handler.codec.http.HttpResponseStatus;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Base64;
import java.util.stream.Stream;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import top.yein.chaos.biz.BizCodeException;

/**
 * HTTP REST 异常处理器.
 *
 * @author KK (kzou227@qq.com)
 */
@Log4j2
public class HttpExceptionHandler extends AbstractRestSupport {

  private static final Key<byte[]> GRPC_ERROR_INFO_KEY =
      Key.of("error-info-bin", Metadata.BINARY_BYTE_MARSHALLER);

  /** 是否为调试模式. */
  private final boolean debug;

  /**
   * 默认构造函数.
   *
   * <p>默认 {@link Env#current()} 当前运行环境为等于 {@link Env#PROD} 时，自动开启调试模式.
   */
  public HttpExceptionHandler() {
    this(Env.current() != Env.PROD);
  }

  /**
   * 可开关调试模式的构造函数.
   *
   * @param debug 是否开启调试模式
   */
  public HttpExceptionHandler(boolean debug) {
    this.debug = debug;
  }

  /**
   * 应用处理器.
   *
   * @param request 请求对象
   * @param response 响应对象
   * @param t 异常对象
   * @return RS
   */
  public Mono<Void> apply(HttpServerRequest request, HttpServerResponse response, Throwable t) {
    var builder = ErrorResult.Error.builder();
    boolean errorLog = false;
    if (t instanceof BizCodeException) {
      var ex = (BizCodeException) t;
      var bc = ex.getBizCode();
      builder
          .code(bc.getCode())
          .status(bc.getHttpStatus())
          .message(bc.getMessage())
          .developerMessage(ex.getMessage());

      var contextEntries = ex.getContextEntries();
      if (!contextEntries.isEmpty()) {
        builder.details(contextEntries);
      }
      errorLog = bc.getHttpStatus() >= HttpResponseStatus.INTERNAL_SERVER_ERROR.code();
    } else if (t instanceof StatusException) { // gRPC
      var ex = (StatusException) t;
      if (!perform(ex.getTrailers(), builder)) {
        builder
            .code(500)
            .status(500)
            .message(Strings.lenientFormat("gRPC错误[%s]", ex.getStatus().getCode()))
            .developerMessage(ex.getMessage());
        errorLog = true;
      }
    } else if (t instanceof StatusRuntimeException) { // gRPC
      var ex = (StatusRuntimeException) t;
      if (!perform(ex.getTrailers(), builder)) {
        builder
            .code(500)
            .status(500)
            .message(Strings.lenientFormat("gRPC错误[%s]", ex.getStatus().getCode()))
            .developerMessage(ex.getMessage());
        errorLog = true;
      }
    } else if (t instanceof ConstraintViolationsException) { // 参数校验异常
      var ex = (ConstraintViolationsException) t;
      builder
          .code(400)
          .status(400)
          .message("请求参数错误")
          .developerMessage(ex.getMessage())
          .details(ex.violations().stream().map(ConstraintViolation::detail));
    } else {
      builder.status(500).code(500).message("服务器错误").developerMessage(t.getMessage());
      errorLog = true;
    }

    // 是否打印 DEBUG 日志
    var debugEnabled = this.debug || queryParam(request, "debug") != null;
    if (errorLog) {
      // 服务器内部错误需要记录 ERROR 日志
      log.error("服务器内部异常 uri={}", request.uri(), t);
    } else if (debugEnabled) {
      // debug 模式下将异常错误信息记录为 DEBUG 日志
      log.debug("请求错误 uri={}", request.uri(), t);
    }

    if (debugEnabled) {
      // debug 模式下将异常堆栈输出至客户端
      builder.stacktrace(getStackTrace(t));
    }

    // 错误响应
    var error = builder.build();
    // 设置 HTTP 错误状态码
    response.status(error.getStatus());
    return json(response, new ErrorResult(error));
  }

  private boolean perform(Metadata trailers, ErrorResult.Error.ErrorBuilder builder) {
    if (trailers == null) {
      return false;
    }

    var bytes = trailers.get(GRPC_ERROR_INFO_KEY);
    if (bytes == null) {
      return false;
    }

    ErrorInfo info;
    try {
      info = ErrorInfo.parseFrom(bytes);
    } catch (InvalidProtocolBufferException e) {
      log.error("解析gRPC错误信息错误 >>> {}", Base64.getEncoder().encodeToString(bytes), e);
      builder.code(-1).status(500).message("解析gRPC错误信息错误").developerMessage(e.getMessage());
      return true;
    }

    builder.code(info.getCode()).status(info.getHttpStatus()).message(info.getMessage());
    return true;
  }

  private Stream<String> getStackTrace(Throwable t) {
    var sw = new StringWriter();
    t.printStackTrace(new PrintWriter(sw));
    return sw.toString()
        .lines()
        .map(
            s -> {
              String rs = s;
              while (rs.indexOf("\t") != -1) {
                rs = rs.replaceFirst("\t", "  ");
              }
              return rs;
            });
  }
}
