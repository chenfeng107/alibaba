create table t_user_message
(
    uid         bigint      not null,
    message_id  varchar(15) not null
);

comment on table t_user_message is '用户消息关联';

comment on column t_user_message.uid is '用户 ID';

comment on column t_user_message.message_id is '消息 ID';

create index t_user_message_message_id_index
    on t_user_message (message_id);