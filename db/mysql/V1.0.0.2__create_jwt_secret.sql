create table t_jwt_secret
(
  id          varchar(8)                          not null comment '主键'
    primary key,
  algorithm   varchar(16)                         not null comment 'JWT 签名算法名称
当前支持 HMAC 家族的加密算法',
  secret      blob                                not null comment '密钥',
  deleted     int       default 0                 null comment '删除数据的时间戳（秒），值不为 0 时，表示该行数据已被软删除',
  create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间'
)
  comment 'JWT密钥';

-- 测试密钥
insert into t_jwt_secret(id, algorithm, secret_key, create_time, update_time)
  values('A0', 'HS512', '4c427b7964b988933b68d2a1644b16b919e3255f9548f502352e2c08f0685557bef33dbdbf6416341e4c71b345f455e04237b7c9a6bc5617bdb03b4deb78f37b', now(), now());
