create table t_user
(
  id          int auto_increment comment '主键'
    primary key,
  origin_uid  varchar(128)                        null comment '源用户ID',
  create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
  constraint t_user_origin_uid_uindex
    unique (origin_uid)
)
  comment '用户信息';
