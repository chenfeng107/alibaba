create table t_group
(
  id          int auto_increment comment '主键'
    primary key,
  creator_id  int                                 not null comment '创建者ID',
  owner_id    int                                 not null comment '群所有者ID',
  member_size int       default 1                 not null comment '群成员数量',
  create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间'
)
  comment '群组信息';
