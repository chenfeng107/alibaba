create table t_user_msg
(
  id char(15) not null
    constraint t_user_msg_pk
      primary key,
  send_uid integer not null,
  rec_uid integer not null,
  content varchar(4096) not null,
  content_type smallint default 0 not null,
  extra varchar(4096),
  unread smallint default 1 not null,
  create_time timestamp default CURRENT_TIMESTAMP not null
);

comment on table t_user_msg is '用户消息';

comment on column t_user_msg.id is '主键消息ID';

comment on column t_user_msg.send_uid is '发送用户ID';

comment on column t_user_msg.rec_uid is '接收用户ID';

comment on column t_user_msg.content is '消息内容';

comment on column t_user_msg.content_type is '消息内容类型
0: 文本消息';

comment on column t_user_msg.extra is '扩展参数';

comment on column t_user_msg.unread is '是否未读
1: 未读
0: 已读';

comment on column t_user_msg.create_time is '创建时间';

create index t_user_msg_create_time_index
  on t_user_msg (create_time);

create index t_user_msg_rec_uid_index
  on t_user_msg (rec_uid);

create index t_user_msg_send_uid_index
  on t_user_msg (send_uid);
