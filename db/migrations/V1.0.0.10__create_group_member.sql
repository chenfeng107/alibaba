create table t_group_member
(
    gid         bigint    not null,
    uid         bigint    not null,
    create_time timestamp default CURRENT_TIMESTAMP not null
);

comment on table t_group_member is '群成员';

comment on column t_group_member.gid is '群 ID';

comment on column t_group_member.uid is '用户 ID';

comment on column t_group_member.create_time is '创建时间';

create unique index t_group_member_gid_uid_uindex
    on t_group_member (gid, uid);