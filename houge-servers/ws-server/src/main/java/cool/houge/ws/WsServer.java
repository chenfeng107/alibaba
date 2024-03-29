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

import com.google.common.net.HostAndPort;
import com.typesafe.config.Config;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.netty.DisposableServer;
import reactor.netty.http.HttpResources;
import reactor.netty.http.server.HttpServer;
import reactor.netty.http.server.HttpServerRoutes;
import reactor.netty.http.server.WebsocketServerSpec;
import reactor.netty.resources.LoopResources;

/**
 * WebSocket服务.
 *
 * @author KK (kzou227@qq.com)
 */
public class WsServer {

  private static final Logger log = LogManager.getLogger();
  private final WebSocketHandler webSocketHandler;
  private final String addr;

  private DisposableServer disposableServer;

  /**
   * 使用服务配置与消息处理器构造对象.
   *
   * @param config 应用配置
   * @param webSocketHandler WebSocket消息处理器
   */
  public @Inject WsServer(Config config, WebSocketHandler webSocketHandler) {
    this.webSocketHandler = webSocketHandler;
    this.addr = config.getString("ws.server.addr");
  }

  /**
   * 启动WebSocket服务.
   *
   * <p>服务启动完成后可使用WebSocket连接.
   */
  public void start() {
    log.debug("正在启动WS服务 addr={}", this.addr);
    var hap = HostAndPort.fromString(this.addr);
    var routes = HttpServerRoutes.newRoutes();

    routes.ws(
        "/ws", webSocketHandler::handle, WebsocketServerSpec.builder().handlePing(false).build());

    HttpResources.set(
        LoopResources.create(
            "houge-ws",
            Math.max(LoopResources.DEFAULT_IO_SELECT_COUNT, 2),
            LoopResources.DEFAULT_IO_WORKER_COUNT,
            false));
    this.disposableServer =
        HttpServer.create()
            .host(hap.getHost())
            .port(hap.getPort())
            .wiretap(true)
            .handle(routes)
            .bindNow();
    log.info("WS服务启动成功 [{}]", disposableServer.address());
  }

  /**
   * 停止WebSocket服务.
   *
   * <p>释放WS资源.
   */
  public void stop() {
    if (this.disposableServer != null) {
      var address = disposableServer.address();
      this.disposableServer.disposeNow();
      log.info("WS服务停止成功 [{}]", address);
    }
  }
}
