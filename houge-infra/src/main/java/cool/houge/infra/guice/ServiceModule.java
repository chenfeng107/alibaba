package cool.houge.infra.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import cool.houge.domain.service.message.MessageStorageService;
import cool.houge.infra.service.message.MessageStorageServiceImpl;

/** @author KK (kzou227@qq.com) */
public class ServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(MessageStorageService.class).to(MessageStorageServiceImpl.class).in(Scopes.SINGLETON);
  }
}
