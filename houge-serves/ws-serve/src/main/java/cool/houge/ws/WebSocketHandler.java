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
package cool.houge.ws;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.InvalidProtocolBufferException;
import cool.houge.protos.ErrorInfo;
import cool.houge.ws.packet.ErrorPacket;
import cool.houge.ws.packet.ErrorPacket.ErrorPacketBuilder;
import cool.houge.ws.packet.MsgPacket;
import cool.houge.ws.packet.Packet;
import cool.houge.ws.session.DefaultSession;
import cool.houge.ws.session.Session;
import cool.houge.ws.session.SessionGroupManager;
import cool.houge.ws.session.SessionManager;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;
import reactor.netty.http.HttpInfos;
import reactor.netty.http.websocket.WebsocketInbound;
import reactor.netty.http.websocket.WebsocketOutbound;

/**
 * WebSocket消息处理器.
 *
 * @author KK (kzou227@qq.com)
 */
public class WebSocketHandler {

  private static final Logger log = LogManager.getLogger();

  /** Authentication HTTP Header 认证的 Scheme. */
  private static final String BEARER_TOKEN_PREFIX = "Bearer ";
  /** 认证令牌在 query 参数中的名称. */
  private static final String ACCESS_TOKEN_QUERY_NAME = "access_token";

  private final SessionManager sessionManager;
  private final SessionGroupManager sessionGroupManager;
  private final LibService libService;
  private final ObjectReader objectReader;
  private final ObjectWriter objectWriter;

  /**
   * @param sessionManager
   * @param sessionGroupManager
   * @param libService
   */
  @Inject
  public WebSocketHandler(
      SessionManager sessionManager,
      SessionGroupManager sessionGroupManager,
      LibService libService) {
    this.sessionManager = sessionManager;
    this.sessionGroupManager = sessionGroupManager;
    this.libService = libService;

    var objectMapper = initObjectMapper();
    this.objectReader = objectMapper.readerFor(Packet.class);
    this.objectWriter = objectMapper.writerFor(Packet.class);
  }

  /**
   * @param inbound
   * @param outbound
   * @return
   */
  public Mono<Void> handle(WebsocketInbound inbound, WebsocketOutbound outbound) {
    // 1. 会话认证
    // 2. 接收WebSocket消息
    return Mono.defer(() -> authenticate(inbound, outbound))
        .doOnSuccess(session -> receiveFrames(inbound, outbound, session))
        .then(outbound.neverComplete())
        .onErrorResume(t -> this.errorHandle(outbound, t).then(outbound.sendClose()));
  }

  @VisibleForTesting
  void receiveFrames(WebsocketInbound inbound, WebsocketOutbound outbound, Session session) {
    sessionManager
        .add(session)
        .thenMany(inbound.aggregateFrames().receiveFrames())
        .doFinally(
            signalType -> {
              log.info("会话中止 signType={} {}", signalType, session);
              // 删除会话管理器中的 Session
              sessionManager.remove(session).subscribe();
              // 删除群组会话管理器中的 Session
              sessionGroupManager.unsubGroups(session, session.subGroupIds()).subscribe();
            })
        .doOnError(
            ex -> {
              log.error("未处理的异常 session={}", session, ex);
              outbound.sendClose().subscribe();
            })
        .subscribe(
            frame -> {
              // 处理WebSocket消息
              processFrame(frame, session)
                  .doOnError(
                      t -> {
                        // 记录错误日志
                        log.error("处理WS消息出现未处理的异常 session={}", session, t);
                      })
                  .onErrorResume(
                      t -> {
                        // 错误处理
                        return this.errorHandle(outbound, t);
                      })
                  .subscribe();
            });
  }

  @VisibleForTesting
  Mono<Void> processFrame(WebSocketFrame frame, Session session) {
    InputStream in = new ByteBufInputStream(frame.content());
    Packet packet;
    try {
      packet = objectReader.readValue(in);
    } catch (IOException e) {
      log.warn("非法的JSON请求数据", e);
      var ep = ErrorPacket.builder().build();
      return session.send(ep);
    }

    log.debug("处理消息包 session={} packet={}", session, packet);
    if (packet instanceof MsgPacket) {
      return libService.processMsgPacket(session, (MsgPacket) packet);
    }

    log.warn("未实现的Packet session={} packet={}", session, packet);
    return Mono.empty();
  }

  @VisibleForTesting
  Mono<Session> authenticate(WebsocketInbound in, WebsocketOutbound out) {
    String token;
    try {
      token = getToken(in);
    } catch (IllegalArgumentException e) {
      log.debug("[连接关闭]-错误的认证参数 {}", in, e);
      out.sendClose(1007, e.getMessage());
      return Mono.empty();
    }

    return libService
        .auth(token)
        .<Session>map(
            uid -> {
              log.info("认证成功 uid={}");
              return new DefaultSession(in, out, uid, token);
            });
  }

  @VisibleForTesting
  String getToken(WebsocketInbound in) throws IllegalArgumentException {
    var bearer = in.headers().get(HttpHeaderNames.AUTHORIZATION);
    if (bearer != null) {
      if (!bearer.startsWith(BEARER_TOKEN_PREFIX)) {
        throw new IllegalArgumentException("header认证必须使用Bearer模式");
      }
      return bearer.substring(BEARER_TOKEN_PREFIX.length());
    }

    final var httpInfos = (HttpInfos) in;
    final var queryParams = new QueryStringDecoder(httpInfos.uri());
    final var params = queryParams.parameters().get(ACCESS_TOKEN_QUERY_NAME);
    if (params == null || params.isEmpty()) {
      throw new IllegalArgumentException("QUERY中缺少\"access_token\"认证参数");
    }
    return params.get(0);
  }

  Mono<Void> errorHandle(WebsocketOutbound outbound, Throwable t) {
    //
    var builder = ErrorPacket.builder();
    if (t instanceof StatusException) {
      var ex = (StatusException) t;
      if (!fromMetadata(ex.getTrailers(), builder)) {
        builder.code(-1).message(t.getMessage());
      }
    } else if (t instanceof StatusRuntimeException) {
      var ex = (StatusRuntimeException) t;
      if (!fromMetadata(ex.getTrailers(), builder)) {
        builder.code(-1).message(t.getMessage());
      }
    }

    var buf = outbound.alloc().buffer();
    OutputStream out = new ByteBufOutputStream(buf);
    try {
      objectWriter.writeValue(out, builder.build());
    } catch (IOException e) {
      log.info("序列化JSON出现错误 packet={}", builder.build(), e);
    }

    // 响应错误消息
    return outbound.sendObject(new TextWebSocketFrame(buf)).then();
  }

  boolean fromMetadata(Metadata trailers, ErrorPacketBuilder builder) {
    var bytes = trailers.get(Key.of("error-info-bin", Metadata.BINARY_BYTE_MARSHALLER));
    if (bytes != null) {
      try {
        var info = ErrorInfo.parseFrom(bytes);
        builder.code(info.getCode()).message(info.getMessage());
        return true;
      } catch (InvalidProtocolBufferException e) {
        log.error("非法的错误信息", e);
      }
    }
    return false;
  }

  static ObjectMapper initObjectMapper() {
    var objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);
    objectMapper.setDefaultPropertyInclusion(Include.NON_DEFAULT);
    return objectMapper;
  }
}
