create table t_group
(
  id serial
    constraint t_group_pk
      primary key,
  origin_gid varchar(128),
  creator_uid integer not null,
  member_uids integer[] not null,
  ver integer default 1 not null,
  create_time timestamp default CURRENT_TIMESTAMP not null,
  update_time timestamp default CURRENT_TIMESTAMP not null
);

comment on table t_group is '群组信息';

comment on column t_group.id is '群ID';

comment on column t_group.origin_gid is '源群组ID';

comment on column t_group.creator_uid is '创建者用户ID';

comment on column t_group.member_uids is '成员用户IDs';

comment on column t_group.ver is '数据版本';

comment on column t_group.create_time is '创建时间';

comment on column t_group.update_time is '更新时间';
