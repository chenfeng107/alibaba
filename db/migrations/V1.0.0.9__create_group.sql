create sequence group_id_seq;

comment on sequence group_id_seq is '群 ID 生成序列';

create table t_group
(
    id          bigint    not null
        constraint t_group_pk
            primary key,
    creator_id  bigint    not null,
    owner_id    bigint,
    member_size integer   not null,
    create_time timestamp default CURRENT_TIMESTAMP not null,
    update_time timestamp default CURRENT_TIMESTAMP not null
);

comment on table t_group is '群信息';

comment on column t_group.id is '群 ID';

comment on column t_group.creator_id is '创建者用户 ID';

comment on column t_group.owner_id is '拥有者用户 ID';

comment on column t_group.member_size is '群成员数量';

comment on column t_group.create_time is '创建时间';

comment on column t_group.update_time is '更新时间';
