create table t_jwt_secret
(
  id varchar(18) not null
    constraint t_jwt_secret_pk
      primary key,
  algorithm varchar(18) not null,
  secret bytea not null,
  deleted bigint default 0 not null,
  ver integer default 1 not null,
  create_time timestamp default CURRENT_TIMESTAMP not null,
  update_time timestamp default CURRENT_TIMESTAMP not null
);

comment on column t_jwt_secret.id is '主键';

comment on column t_jwt_secret.algorithm is 'JWT签名算法名称';

comment on column t_jwt_secret.secret is '密钥';

comment on column t_jwt_secret.ver is '数据版本';

comment on column t_jwt_secret.create_time is '创建时间';

comment on column t_jwt_secret.update_time is '更新时间';
