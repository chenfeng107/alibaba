create table t_message
(
    id           char(15)                not null,
    sender_id    bigint,
    receiver_id  bigint,
    group_id     bigint,
    kind         smallint  default 0     not null,
    content      varchar(4096),
    content_type smallint  default 0     not null,
    extra_args   varchar(2048),
    unread       smallint  default 0,
    create_time timestamp default CURRENT_TIMESTAMP not null,
    update_time timestamp default CURRENT_TIMESTAMP not null
);

comment on table t_message is '消息表';

comment on column t_message.id is '全局消息 ID';

comment on column t_message.sender_id is '发送人 ID';

comment on column t_message.receiver_id is '接收人 ID';

comment on column t_message.group_id is '群 ID';

comment on column t_message.kind is '消息类型
0: 私人消息
1: 群组消息
8: 系统消息-单人
9: 系统消息-群组';

comment on column t_message.content is '消息内容';

comment on column t_message.content_type is '消息内容类型
0: 文本消息
1: 图片消息
2: 音频消息
3: 视频消息';

comment on column t_message.extra_args is '扩展参数';

comment on column t_message.unread is '消息是否未读
0: 已读
1: 未读';

comment on column t_message.create_time is '创建时间';

comment on column t_message.update_time is '更新时间';

create unique index t_message_id_uindex
    on t_message (id);
