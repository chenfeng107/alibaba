create sequence user_id_seq;

comment on sequence user_id_seq is '用户 ID 生成序列';

create table t_user
(
    id          bigint    not null
        constraint t_user_pk
            primary key,
    origin_uid  varchar(128),
    create_time timestamp default CURRENT_TIMESTAMP not null,
    update_time timestamp default CURRENT_TIMESTAMP not null
);

comment on column t_user.origin_uid is '原用户 ID';

comment on column t_user.create_time is '创建时间';

comment on column t_user.update_time is '更新时间';

create unique index t_user_origin_uid_uindex
    on t_user (origin_uid);