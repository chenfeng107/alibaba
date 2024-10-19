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
package top.yein.tethys.storage.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.typesafe.config.Config;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import top.yein.tethys.ConfigKeys;
import top.yein.tethys.core.r2dbc.DefaultR2dbcClient;
import top.yein.tethys.r2dbc.R2dbcClient;
import top.yein.tethys.storage.GroupDao;
import top.yein.tethys.storage.GroupDaoImpl;
import top.yein.tethys.storage.JwtSecretDao;
import top.yein.tethys.storage.JwtSecretDaoImpl;
import top.yein.tethys.storage.MessageDao;
import top.yein.tethys.storage.MessageDaoImpl;
import top.yein.tethys.storage.ServerInstanceDao;
import top.yein.tethys.storage.ServerInstanceDaoImpl;
import top.yein.tethys.storage.UserDao;
import top.yein.tethys.storage.UserDaoImpl;
import top.yein.tethys.storage.query.GroupQueryDao;
import top.yein.tethys.storage.query.GroupQueryDaoImpl;
import top.yein.tethys.storage.query.MessageQueryDao;
import top.yein.tethys.storage.query.MessageQueryDaoImpl;
import top.yein.tethys.storage.query.UserQueryDao;
import top.yein.tethys.storage.query.UserQueryDaoImpl;

/**
 * 消息数据存储模块定义.
 *
 * @author KK (kzou227@qq.com)
 */
public class StorageModule extends AbstractModule {

  private final Config config;

  /**
   * 使用配置创建模块对象.
   *
   * @param config 应用配置
   */
  public StorageModule(Config config) {
    this.config = config;
  }

  @Override
  protected void configure() {
    bind(ServerInstanceDao.class).to(ServerInstanceDaoImpl.class).in(Scopes.SINGLETON);
    bind(JwtSecretDao.class).to(JwtSecretDaoImpl.class).in(Scopes.SINGLETON);

    // 消息
    bind(MessageDao.class).to(MessageDaoImpl.class).in(Scopes.SINGLETON);
    bind(MessageQueryDao.class).to(MessageQueryDaoImpl.class).in(Scopes.SINGLETON);

    // 用户
    bind(UserDao.class).to(UserDaoImpl.class).in(Scopes.SINGLETON);
    bind(UserQueryDao.class).to(UserQueryDaoImpl.class).in(Scopes.SINGLETON);

    // 群组
    bind(GroupDao.class).to(GroupDaoImpl.class).in(Scopes.SINGLETON);
    bind(GroupQueryDao.class).to(GroupQueryDaoImpl.class).in(Scopes.SINGLETON);
  }

  @Provides
  public ConnectionFactory connectionFactory() {
    var r2dbcUrl = config.getString(ConfigKeys.MESSAGE_STORAGE_R2DBC_URL);
    return ConnectionFactories.get(r2dbcUrl);
  }

  @Provides
  public R2dbcClient r2dbcClient(ConnectionFactory connectionFactory) {
    return new DefaultR2dbcClient(connectionFactory);
  }
}