create table t_msg
(
  id           varchar(32)                         not null comment '消息ID',
  sender_id    int                                 not null comment '发送者ID',
  receiver_id  int                                 null comment '接收者ID',
  group_id     int                                 null comment '群组ID',
  content      varchar(4096)                       null comment '消息内容',
  content_type smallint  default 0                 not null comment '消息内容类型
0: 文本消息
1: 图片消息
2: 音频消息
3: 视频消息',
  extra        varchar(2048)                       null comment '扩展参数',
  unread       smallint  default 1                 null comment '是否未读
1: 未读
0: 已读',
  create_time  timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
  constraint t_msg_id_uindex
    unique (id)
)
  comment '消息内容';
