create table t_user_msg
(
  uid    int         not null comment '用户ID',
  msg_id varchar(32) not null comment '消息ID'
)
  comment '用户消息';

create index t_user_msg_uid_index
  on t_user_msg (uid);
