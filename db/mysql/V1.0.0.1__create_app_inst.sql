create table t_app_inst
(
  id              int auto_increment comment '主键'
    primary key,
  app_name        varchar(128)                        not null comment '应用名称',
  host_name       varchar(128)                        not null comment '主机名称',
  host_address    varchar(128)                        not null comment '主机地址',
  os_name         varchar(128)                        null comment '系统名称',
  os_version      varchar(128)                        null comment '系统版本',
  os_user         varchar(128)                        null comment '启动用户',
  java_vm_name    varchar(128)                        null comment 'Java虚拟机名称',
  java_vm_version varchar(128)                        null comment 'Java虚拟机版本',
  java_vm_vendor  varchar(128)                        null comment 'Java虚拟机供应商',
  work_dir        varchar(128)                        null comment '应用工作目录',
  pid             int                                 not null comment '进程ID',
  ver             int       default 1                 not null comment '数据版本',
  create_time     timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
  check_time      timestamp default CURRENT_TIMESTAMP not null comment '检查时间'
)
  comment '应用实例';
