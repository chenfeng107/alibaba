create table t_group_msg
(
  id char(15) not null
    constraint t_group_msg_pk
      primary key,
  send_uid integer not null,
  group_id integer,
  content varchar(4096) not null,
  content_type smallint default 0 not null,
  extra varchar(4096),
  create_time timestamp default CURRENT_TIMESTAMP not null
);

comment on table t_group_msg is '群组消息';

comment on column t_group_msg.id is '消息ID';

comment on column t_group_msg.send_uid is '发送者ID';

comment on column t_group_msg.group_id is '接收群组ID';

comment on column t_group_msg.content is '消息内容';

comment on column t_group_msg.content_type is '消息内容类型
0: 文本消息';

comment on column t_group_msg.extra is '扩展参数';

comment on column t_group_msg.create_time is '创建时间';

create index t_group_msg_create_time_index
  on t_group_msg (create_time);

create index t_group_msg_group_id_index
  on t_group_msg (group_id);
