package cool.houge.infra.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import cool.houge.domain.BizCodes;
import cool.houge.domain.auth.TokenInfo;
import cool.houge.domain.auth.TokenService;
import cool.houge.domain.model.JwtSecret;
import cool.houge.domain.shared.JwtSecretDao;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import top.yein.chaos.biz.BizCode;
import top.yein.chaos.biz.BizCodeException;
import top.yein.chaos.biz.StacklessBizCodeException;

/** @author KK (kzou227@qq.com) */
public class TokenServiceImpl implements TokenService {

  private static final Logger log = LogManager.getLogger();
  private final JwtSecretDao jwtSecretDao;
  private final AsyncCache<String, CachedJwtSecret> jwtSecretCache;

  public @Inject TokenServiceImpl(JwtSecretDao jwtSecretDao) {
    this.jwtSecretDao = jwtSecretDao;

    this.jwtSecretCache =
        Caffeine.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(30, TimeUnit.MINUTES)
            .refreshAfterWrite(5, TimeUnit.MINUTES)
            .buildAsync(this::loadJwtSecret);
  }

  @Override
  public Mono<String> generateToken(int uid) {
    return generateToken0(uid);
  }

  @Override
  public Mono<TokenInfo> verify(String token) {
    // 解码 JWT
    DecodedJWT jwt;
    try {
      jwt = JWT.decode(token);
    } catch (JWTDecodeException e) {
      throw new BizCodeException(BizCodes.C3300, e);
    }

    var key = jwt.getKeyId();
    return Mono.fromCompletionStage(jwtSecretCache.get(key, this::loadJwtSecret))
        .switchIfEmpty(
            Mono.error(
                () -> {
                  log.error("未找到JwtSecret配置 key={} token={}", key, token);
                  return new StacklessBizCodeException(BizCodes.C3309);
                }))
        .doOnNext(cjs -> verify(cjs, jwt))
        .map(
            cjs -> {
              var uid = Integer.parseInt(jwt.getId());
              return TokenInfo.builder().uid(uid).build();
            });
  }

  Mono<String> generateToken0(int uid) {
    return Flux.fromIterable(jwtSecretCache.asMap().values())
        .flatMap(Mono::fromFuture)
        .switchIfEmpty(this.loadAll())
        .sort()
        .single()
        .map(
            cjs -> {
              // FIXME 设置令牌的过期时间，增加令牌其它参数
              var token =
                  JWT.create()
                      .withKeyId(cjs.kid)
                      .withJWTId(String.valueOf(uid))
                      .sign(cjs.algorithm);
              log.info("生成访问令牌 [kid={}, uid={}]", cjs.kid, uid);
              return token;
            });
  }

  Flux<CachedJwtSecret> loadAll() {
    return jwtSecretDao
        .findAll()
        .map(this::toCachedJwtSecret)
        // .switchIfEmpty(Flux.error(() -> new BizCodeException(BizCodes.C3310)))
        .doOnNext(
            cjs -> {
              log.info("将JwtSecret添加至缓存中 kid={}", cjs.kid);
              jwtSecretCache.put(cjs.kid, CompletableFuture.completedFuture(cjs));
            });
  }

  void verify(CachedJwtSecret cjs, DecodedJWT jwt) {
    var verifier =
        JWT.require(cjs.algorithm).acceptLeeway(Duration.ofMinutes(3).getSeconds()).build();
    try {
      verifier.verify(jwt);
    } catch (TokenExpiredException e) {
      throw new BizCodeException(BizCodes.C3301, e);
    } catch (InvalidClaimException e) {
      throw new BizCodeException(BizCodes.C3302, e);
    } catch (SignatureVerificationException e) {
      throw new BizCodeException(BizCodes.C3305, e);
    } catch (JWTVerificationException e) {
      throw new BizCodeException(BizCodes.C3300, e);
    }
  }

  CompletableFuture<CachedJwtSecret> loadJwtSecret(String key, Executor executor) {
    log.info("将JwtSecret最新数据加入缓存 key={}", key);
    return findJwtSecret(key)
        .subscribeOn(Schedulers.fromExecutor(executor))
        .doOnSuccess((cjs) -> log.info("JwtSecret最新数据已成功加入缓存 key={} cjs", key, cjs))
        .toFuture();
  }

  Mono<CachedJwtSecret> findJwtSecret(String id) {
    return jwtSecretDao.findById(id).map(this::toCachedJwtSecret);
  }

  CachedJwtSecret toCachedJwtSecret(JwtSecret jwtSecret) {
    Algorithm algorithm;
    if ("HS256".equals(jwtSecret.getAlgorithm())) {
      algorithm = Algorithm.HMAC256(jwtSecret.getSecret());
    } else if ("HS512".equals(jwtSecret.getAlgorithm())) {
      algorithm = Algorithm.HMAC512(jwtSecret.getSecret());
    } else {
      throw new BizCodeException(BizCode.C404)
          .addContextValue("algorithm", jwtSecret.getAlgorithm());
    }

    var cjs = new CachedJwtSecret();
    cjs.kid = jwtSecret.getId();
    cjs.algorithm = algorithm;
    cjs.deleted = jwtSecret.getDeleted();
    return cjs;
  }

  private static class CachedJwtSecret {

    String kid;
    Algorithm algorithm;
    int deleted;
  }
}
