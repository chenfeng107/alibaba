create table t_group_member
(
  gid         int                                 not null comment '群组ID',
  uid         int                                 not null comment '用户ID',
  create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间'
)
  comment '群组成员关系';

create index t_group_member_gid_index
  on t_group_member (gid);

create index t_group_member_uid_index
  on t_group_member (uid);
