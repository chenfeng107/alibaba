package cool.houge.infra.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import cool.houge.domain.auth.TokenService;
import cool.houge.infra.service.TokenServiceImpl;

/** @author KK (kzou227@qq.com) */
public class ServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TokenService.class).to(TokenServiceImpl.class).in(Scopes.SINGLETON);
  }
}
