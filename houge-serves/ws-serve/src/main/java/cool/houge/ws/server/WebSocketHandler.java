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
package cool.houge.ws.server;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.google.common.annotations.VisibleForTesting;
import cool.houge.grpc.AuthRequest;
import cool.houge.grpc.ListGidsRequest;
import cool.houge.grpc.ReactorHybridGrpc.ReactorHybridStub;
import cool.houge.grpc.SendMsgRequest;
import cool.houge.grpc.SendMsgResponse;
import cool.houge.protos.MsgContentType;
import cool.houge.ws.packet.ErrorPacket;
import cool.houge.ws.packet.MsgPacket;
import cool.houge.ws.packet.Packet;
import cool.houge.ws.packet.PrivateMsgPacket;
import cool.houge.ws.session.DefaultSession;
import cool.houge.ws.session.Session;
import cool.houge.ws.session.SessionGroupManager;
import cool.houge.ws.session.SessionManager;
import io.netty.buffer.ByteBufInputStream;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
  private final ReactorHybridStub hybridStub;
  private final ObjectReader objectReader;

  /**
   * @param hybridStub
   * @param sessionManager
   * @param sessionGroupManager
   */
  @Inject
  public WebSocketHandler(
      SessionManager sessionManager,
      SessionGroupManager sessionGroupManager,
      ReactorHybridStub hybridStub) {
    this.sessionManager = sessionManager;
    this.sessionGroupManager = sessionGroupManager;
    this.hybridStub = hybridStub;

    var objectMapper = initObjectMapper();
    this.objectReader = objectMapper.readerFor(Packet.class);
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
        .flatMap(
            session -> {
              log.debug("加载用户 {} 的群组信息", session);
              return loadGids(session.uid())
                  .flatMap(gids -> sessionGroupManager.subGroups(session, gids))
                  .thenReturn(session);
            })
        .doOnSuccess(session -> receiveFrames(inbound, outbound, session))
        .then(outbound.neverComplete());
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
      return sendMsgPacket(session, (MsgPacket) packet);
    }

    log.warn("未实现的Packet session={} packet={}", session, packet);
    return Mono.empty();
  }

  Mono<Void> sendMsgPacket(Session session, MsgPacket p) {
    var contentType = MsgContentType.forNumber(p.getContentType());
    // FIXME 校验 content-type

    var builder = SendMsgRequest.newBuilder();
    builder
        .setFrom(p.getFrom() == null ? session.uid() : p.getFrom())
        .setTo(p.getTo())
        .setContent(p.getContent())
        .setContentType(contentType);
    if (p.getExtra() != null) {
      builder.setExtra(p.getExtra());
    }

    Mono<SendMsgResponse> m;
    if (p instanceof PrivateMsgPacket) {
      m = hybridStub.sendToUser(builder.build());
    } else {
      m = hybridStub.sendToGroup(builder.build());
    }
    // FIXME
    return m.then();
  }

  @VisibleForTesting
  Mono<List<Integer>> loadGids(int uid) {
    var request = ListGidsRequest.newBuilder().setUid(uid).build();
    return hybridStub.listGids(request).map(response -> response.getGidsList());
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

    var request = AuthRequest.newBuilder().setToken(token).build();
    return hybridStub
        .auth(request)
        .map(
            response -> {
              log.info("认证成功 uid={}", response.getUid());
              return new DefaultSession(in, out, response.getUid(), token);
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

  static ObjectMapper initObjectMapper() {
    var objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);
    objectMapper.setDefaultPropertyInclusion(Include.NON_DEFAULT);
    return objectMapper;
  }
}
