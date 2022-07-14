package top.yein.tethys.core.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.MediaType;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import top.yein.chaos.biz.BizCodeException;
import top.yein.tethys.core.BizCodes;
import top.yein.tethys.util.JsonUtils;
import top.yein.tethys.util.ReactorHttpServerUtils;

/**
 * REST 抽象支撑类.
 *
 * @author KK (kzou227@qq.com)
 */
@Log4j2
public abstract class AbstractRestSupport {

  /**
   * 获取 {@link HttpServerRequest} 查询参数值.
   *
   * @param request HTTP 请求对象
   * @param name 查询参数名称
   * @return 查询参数值
   */
  protected String queryParam(HttpServerRequest request, String name) {
    return ReactorHttpServerUtils.queryParam(request, name);
  }

  /**
   * 获取 {@link HttpServerRequest} 查询参数值列表.
   *
   * @param request HTTP 请求对象
   * @param name 查询参数名称
   * @return 查询参数值列表
   */
  protected List<String> queryParams(HttpServerRequest request, String name) {
    return ReactorHttpServerUtils.queryParams(request, name);
  }

  /**
   * 获取 {@link HttpServerRequest} 查询所有查询参数.
   *
   * @param request HTTP 请求对象
   * @return 查询参数值映射
   */
  protected Map<String, List<String>> queryParams(HttpServerRequest request) {
    return ReactorHttpServerUtils.queryParams(request);
  }

  /**
   * 解析 HTTP 请求 JSON BODY.
   *
   * @param request HTTP 请求对象
   * @param clazz body class
   * @param <T> 泛型
   * @return RS
   */
  protected <T> Mono<T> json(HttpServerRequest request, Class<T> clazz) {
    // TODO: 校验 content-type
    return request
        .receiveContent()
        .map(
            httpContent -> {
              InputStream in = new ByteBufInputStream(httpContent.content());
              try {
                return getObjectMapper().readValue(in, clazz);
              } catch (IOException e) {
                throw new BizCodeException(BizCodes.C400, "解析JSON异常", e);
              }
            })
        .next();
  }

  /**
   * 输入 HTTP 响应 JSON BODY.
   *
   * @param response HTTP 响应对象
   * @param value 响应 BODY 对象
   * @return RS
   */
  protected Mono<Void> json(HttpServerResponse response, Object value) {
    var buf = response.alloc().directBuffer();
    OutputStream out = new ByteBufOutputStream(buf);
    try {
      getObjectMapper().writeValue(out, value);
      return response
          .header(HttpHeaderNames.CONTENT_TYPE, MediaType.JSON_UTF_8.toString())
          .send(Mono.just(buf))
          .then();
    } catch (IOException e) {
      // 序列化 JSON 失败响应错误信息
      log.error("http response json 序列化错误 [value={}]", e, value);
      return response.status(HttpResponseStatus.INTERNAL_SERVER_ERROR).send();
    }
  }

  private ObjectMapper getObjectMapper() {
    return JsonUtils.objectMapper();
  }
}