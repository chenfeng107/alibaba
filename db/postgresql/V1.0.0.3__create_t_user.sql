create table t_user
(
  id serial
    constraint t_user_pk
      primary key,
  origin_uid varchar(128),
  group_ids integer[],
  ver integer default 1 not null,
  create_time timestamp default CURRENT_TIMESTAMP not null,
  update_time timestamp default CURRENT_TIMESTAMP not null
);

comment on table t_user is '用户信息';

comment on column t_user.id is '主键';

comment on column t_user.origin_uid is '源用户ID';

comment on column t_user.group_ids is '群组ID';

comment on column t_user.ver is '数据版本';

comment on column t_user.create_time is '创建时间';

comment on column t_user.update_time is '更新时间';
