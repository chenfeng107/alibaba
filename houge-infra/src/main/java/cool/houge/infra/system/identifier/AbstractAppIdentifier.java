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
package cool.houge.infra.system.identifier;

import cool.houge.Version;
import cool.houge.domain.model.AppInst;
import cool.houge.domain.system.AppInstDao;
import cool.houge.util.HostNameUtils;
import cool.houge.util.YeinGid;
import io.r2dbc.spi.R2dbcDataIntegrityViolationException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * 抽象应用 ID 实现.
 *
 * @author KK (kzou227@qq.com)
 */
public abstract class AbstractAppIdentifier implements AppIdentifier {

  private static final Logger log = LogManager.getLogger();

  /** 随机生成的 FID 最小值. */
  static final int MIN_FID = 99;
  /** 随机生成的 FID 最大值. */
  static final int MAX_FID = YeinGid.FID_MASK;
  /** 构建 FID 的超时时间（秒）. */
  private static final long MAKE_FID_TIMEOUT = 10;

  // INSTANCE 过期的时间
  private static final long INSTANCE_EXPIRES_IN = Duration.ofHours(1).toSeconds();
  // 健康检查的周期
  private static final Duration CHECK_HEALTH_PERIOD = Duration.ofMinutes(1);

  private final AppInstDao appInstDao;
  private final int fid;

  /**
   * 使用服务实例数据访问对象构造对象.
   *
   * @param appInstDao
   */
  protected AbstractAppIdentifier(AppInstDao appInstDao) {
    this.appInstDao = appInstDao;
    this.fid = getFid();
    this.checkHealth();
  }

  @Override
  public int fid() {
    return this.fid;
  }

  @Override
  public String version() {
    return Version.version();
  }

  @Override
  public void clean() {
    var future = appInstDao.delete(fid).toFuture();
    try {
      future.get(5, TimeUnit.SECONDS);
      log.info("<{}>应用标识[{}]清理完成", appName(), fid);
    } catch (InterruptedException e) {
      log.warn("Interrupted", e);
      Thread.currentThread().interrupt();
    } catch (Exception e) {
      throw new IllegalStateException("<" + appName() + ">应用标识[" + fid + "]清理异常", e);
    }
  }

  // 初始化 Fid
  int getFid() {
    var ran = new SecureRandom();
    var fidFuture = new CompletableFuture<Integer>();
    var isRun = new AtomicBoolean(true);
    var tempFid = new AtomicReference<Integer>();

    Mono.defer(
            () -> {
              var id = ran.nextInt(MAX_FID) + MIN_FID;
              return insertFid(id)
                  .doOnNext(
                      n -> {
                        if (n == 1) {
                          fidFuture.complete(id);
                          isRun.set(false);
                        }
                      });
            })
        .repeat(isRun::get)
        .onErrorContinue(
            ex -> {
              if (ex instanceof R2dbcDataIntegrityViolationException) {
                var t = (R2dbcDataIntegrityViolationException) ex;
                // 数据库唯一索引冲突时继续重试
                if ("23505".equals(t.getSqlState())) {
                  log.warn(
                      "初始化应用实例出现唯一索引冲突 fid:{}, [{}]:{}",
                      tempFid.get(),
                      t.getSqlState(),
                      t.getMessage());
                  return true;
                }
              }

              log.error("初始化应用实例异常 fid:{}", tempFid.get(), ex);
              return false;
            },
            (ex, o) -> {})
        .timeout(Duration.ofSeconds(MAKE_FID_TIMEOUT))
        .subscribeOn(Schedulers.single())
        .subscribe();

    try {
      return fidFuture.get(MAKE_FID_TIMEOUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      log.warn("Interrupted", e);
      Thread.currentThread().interrupt();
      throw new IllegalStateException("获取服务实例 ID 失败", e);
    } catch (ExecutionException | TimeoutException e) {
      throw new IllegalStateException(e);
    }
  }

  Mono<Integer> insertFid(int id) {
    return Mono.defer(
        () -> {
          var m = newInst(id);
          log.info("新增应用实例: {}", m);
          return appInstDao.insert(m);
        });
  }

  AppInst newInst(int id) {
    InetAddress inetAddress;
    try {
      inetAddress = HostNameUtils.getLocalHostLANAddress();
    } catch (UnknownHostException e) {
      throw new IllegalStateException(e);
    }

    var e = new AppInst();
    e.setId(id);
    e.setAppName(appName());
    e.setHostName(inetAddress.getHostName());
    e.setHostAddress(inetAddress.getHostAddress());
    e.setOsName(System.getProperty("os.name"));
    e.setOsVersion(System.getProperty("os.version"));
    e.setOsUser(System.getProperty("user.name"));
    e.setJavaVmName(System.getProperty("java.vm.name"));
    e.setJavaVmVersion(System.getProperty("java.vm.version"));
    e.setJavaVmVendor(System.getProperty("java.vm.vendor"));
    e.setWorkDir(System.getProperty("user.dir"));
    e.setPid(ProcessHandle.current().pid());
    return e;
  }

  private void checkHealth() {
    appInstDao
        .updateCheckTime(fid)
        .doOnSuccess(unused -> log.debug("健康检查成功 fid: {}", fid))
        .onErrorContinue((ex, o) -> log.error("健康检查异常", ex))
        .delaySubscription(CHECK_HEALTH_PERIOD)
        .repeat(() -> true)
        .subscribe();
  }
}
