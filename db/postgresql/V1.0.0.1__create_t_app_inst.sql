create table t_app_inst
(
  id serial
    constraint t_app_inst_pk
      primary key,
  app_name varchar(128),
  host_name varchar(128),
  host_address varchar(128),
  os_name varchar(128),
  os_version varchar(128),
  os_user varchar(128),
  java_vm_name varchar(128),
  java_vm_version varchar(128),
  java_vm_vendor varchar(128),
  work_dir varchar(128),
  pid bigint,
  ver integer default 1 not null,
  create_time timestamp default CURRENT_TIMESTAMP not null,
  check_time timestamp default CURRENT_TIMESTAMP not null
);

comment on table t_app_inst is '应用实例';

comment on column t_app_inst.id is '主键';

comment on column t_app_inst.app_name is '应用名称';

comment on column t_app_inst.host_name is '主机名称';

comment on column t_app_inst.host_address is '主机地址';

comment on column t_app_inst.os_name is '系统名称';

comment on column t_app_inst.os_version is '系统版本';

comment on column t_app_inst.os_user is '启动用户';

comment on column t_app_inst.java_vm_name is 'Java虚拟机名称';

comment on column t_app_inst.java_vm_version is 'Java虚拟机版本';

comment on column t_app_inst.java_vm_vendor is 'Java虚拟机供应商';

comment on column t_app_inst.work_dir is '应用工作目录';

comment on column t_app_inst.pid is '进程ID';

comment on column t_app_inst.ver is '数据版本';

comment on column t_app_inst.create_time is '创建时间';

comment on column t_app_inst.check_time is '最后检查时间';
