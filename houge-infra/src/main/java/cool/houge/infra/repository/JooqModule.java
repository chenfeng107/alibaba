package cool.houge.infra.repository;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import cool.houge.domain.repository.jwt.JwtSecretRepository;
import cool.houge.infra.repository.jwt.JooqJwtSecretRepository;
import cool.houge.infra.repository.system.JooqServerInstanceRepository;
import cool.houge.infra.system.identifier.ServerInstanceRepository;

/**
 * @author KK (kzou227@qq.com)
 */
public class JooqModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ServerInstanceRepository.class).to(JooqServerInstanceRepository.class).in(Scopes.SINGLETON);
    bind(JwtSecretRepository.class).to(JooqJwtSecretRepository.class).in(Scopes.SINGLETON);
  }
}
