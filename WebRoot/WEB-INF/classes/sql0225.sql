/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012-9-2 15:51:34                            */
/*==============================================================*/


drop table if exists biz_Info;

drop table if exists biz_News;

drop table if exists sys_Applications;

drop table if exists sys_Event;

drop table if exists sys_Field;

drop table if exists sys_FieldValue;

drop table if exists sys_Group;

drop table if exists sys_Module;

drop table if exists sys_ModuleExtPermission;

drop table if exists sys_Online;

drop table if exists sys_RoleApplication;

drop table if exists sys_RolePermission;

drop table if exists sys_Roles;

drop table if exists sys_SystemInfo;

drop table if exists sys_User;

drop table if exists sys_UserRoles;

/*==============================================================*/
/* Table: biz_Info                                              */
/*==============================================================*/
create table biz_Info
(
   InfoID               varchar(40) not null,
   Info_domain          varchar(50),
   Info_key             varchar(100),
   Info_value           text,
   Info_properties      varchar(50),
   Info_updatetime      datetime,
   primary key (InfoID)
);

/*==============================================================*/
/* Table: biz_News                                              */
/*==============================================================*/
create table biz_News
(
   NewsID               varchar(40) not null,
   News_title           varchar(250),
   News_cate            varchar(40),
   News_content         text,
   News_keywords        varchar(200),
   News_summery         varchar(500),
   News_Properties      varchar(50),
   News_updatetime      datetime,
   primary key (NewsID)
);

alter table biz_News comment '新闻中心';

/*==============================================================*/
/* Table: sys_Applications                                      */
/*==============================================================*/
create table sys_Applications
(
   ApplicationID        varchar(40) not null comment '自动ID 1:为系统管理应用',
   A_AppName            national varchar(50) comment '应用名称',
   A_AppDescription     national varchar(200) comment '应用介绍',
   A_AppUrl             varchar(50) comment '应用Url地址',
   A_Order              int comment '应用排序',
   primary key (ApplicationID)
);

alter table sys_Applications comment '应用表';

/*==============================================================*/
/* Table: sys_Event                                             */
/*==============================================================*/
create table sys_Event
(
   EventID              varchar(40) not null comment '事件ID号',
   E_U_LoginName        national varchar(20) comment '用户名',
   E_UserID             varchar(40) comment '操作时用户ID与sys_Users中UserID',
   E_DateTime           datetime not null comment '事件发生的日期及时间',
   E_ApplicationID      varchar(40) comment '所属应用程序ID与sys_Applicatio',
   E_A_AppName          national varchar(50) comment '所属应用名称',
   E_M_Name             national varchar(50) comment 'PageCode模块名称与sys_Module相同',
   E_M_PageCode         varchar(6) comment '发生事件时模块名称',
   E_From               national varchar(500) comment '来源',
   E_Type               tinyint not null default 1 comment '日记类型,1:操作日记2:安全日志3',
   E_IP                 varchar(15) comment '客户端IP地址',
   E_Record             national varchar(500) comment '详细描述',
   primary key (EventID)
);

alter table sys_Event comment '系统日记表';

/*==============================================================*/
/* Table: sys_Field                                             */
/*==============================================================*/
create table sys_Field
(
   FieldID              varchar(40) not null comment '应用字段ID号',
   F_Key                varchar(50) comment '应用字段关键字',
   F_CName              national varchar(50) comment '应用字段中文说明',
   F_Remark             national varchar(200) comment '描述说明',
   primary key (FieldID)
);

alter table sys_Field comment '系统应用字段';

/*==============================================================*/
/* Table: sys_FieldValue                                        */
/*==============================================================*/
create table sys_FieldValue
(
   ValueID              varchar(40) not null comment '索引ID号',
   V_F_Key              varchar(50) comment '与sys_Field表中F_Key字段关联',
   V_Text               national varchar(100) comment '中文说明',
   V_Code               varchar(100) comment '编码',
   V_ShowOrder          int not null default 0 comment '同级显示顺序',
   primary key (ValueID)
);

alter table sys_FieldValue comment '应用字段值';

/*==============================================================*/
/* Table: sys_Group                                             */
/*==============================================================*/
create table sys_Group
(
   GroupID              varchar(40) not null comment '分类ID号',
   G_CName              national varchar(50) comment '分类中文说明',
   G_ParentID           varchar(40) not null default '0' comment '上级分类ID0:为最高级',
   G_ShowOrder          int not null default 0 comment '显示顺序',
   G_Level              int comment '当前分类所在层数',
   G_ChildCount         int comment '当前分类子分类数',
   G_Delete             tinyint comment '是否删除1:是0:否',
   primary key (GroupID)
);

alter table sys_Group comment '部门';

/*==============================================================*/
/* Table: sys_Module                                            */
/*==============================================================*/
create table sys_Module
(
   ModuleID             varchar(40) not null comment '功能模块ID号',
   M_ApplicationID      varchar(40) not null comment '所属应用程序ID',
   M_ParentID           varchar(40) not null comment '所属父级模块ID与ModuleID关联,0为顶级',
   M_PageCode           varchar(6) not null comment '模块编码Parent为0,则为S00(xx),否则为S00M00(xx)',
   M_CName              national varchar(50) comment '模块/栏目名称当ParentID为0为模块名称',
   M_Directory          national varchar(255) comment '模块/栏目目录名',
   M_OrderLevel         varchar(4) comment '当前所在排序级别支持双层99级菜单',
   M_IsSystem           tinyint comment '是否为系统模块1:是0:否如为系统则无法修改',
   M_Close              tinyint comment '是否关闭1:是0:否',
   M_Icon               varchar(255) comment '模块Icon',
   primary key (ModuleID)
);

alter table sys_Module comment '功能模块';

/*==============================================================*/
/* Table: sys_ModuleExtPermission                               */
/*==============================================================*/
create table sys_ModuleExtPermission
(
   ExtPermissionID      varchar(40) not null comment '扩展权限ID',
   ModuleID             varchar(40) not null comment '模块ID',
   PermissionName       national varchar(100) not null comment '权限名称',
   PermissionValue      int not null comment '权限值',
   primary key (ModuleID, PermissionValue)
);

alter table sys_ModuleExtPermission comment '模块扩展权限';

/*==============================================================*/
/* Table: sys_Online                                            */
/*==============================================================*/
create table sys_Online
(
   OnlineID             varchar(40) not null comment '自动ID',
   O_SessionID          varchar(24) not null comment '用户SessionID',
   O_UserName           national varchar(20) not null comment '用户名',
   O_Ip                 varchar(15) not null comment '用户IP地址',
   O_LoginTime          datetime not null comment '登陆时间',
   O_LastTime           datetime not null comment '最后访问时间',
   O_LastUrl            national varchar(500) not null comment '最后请求网站',
   primary key (O_SessionID)
);

alter table sys_Online comment '在线用户表';

/*==============================================================*/
/* Table: sys_RoleApplication                                   */
/*==============================================================*/
create table sys_RoleApplication
(
   A_RoleID             varchar(40) not null comment '角色ID与sys_Roles中RoleID相关',
   A_ApplicationID      varchar(40) not null comment '应用ID与sys_Applications中Appl',
   primary key (A_RoleID, A_ApplicationID)
);

alter table sys_RoleApplication comment '角色应用表';

/*==============================================================*/
/* Table: sys_RolePermission                                    */
/*==============================================================*/
create table sys_RolePermission
(
   PermissionID         varchar(40) not null comment '角色应用权限自动ID',
   P_RoleID             varchar(40) not null comment '角色ID与sys_Roles表中RoleID相',
   P_ApplicationID      varchar(40) not null comment '角色所属应用ID与sys_Applicatio',
   P_PageCode           varchar(20) not null comment '角色应用中页面权限代码',
   P_Value              int comment '权限值',
   primary key (P_RoleID, P_ApplicationID, P_PageCode)
);

alter table sys_RolePermission comment '角色应用权限表';

/*==============================================================*/
/* Table: sys_Roles                                             */
/*==============================================================*/
create table sys_Roles
(
   RoleID               varchar(40) not null comment '角色ID自动ID',
   R_UserID             varchar(40) not null comment '角角所属用户ID',
   R_RoleName           national varchar(50) not null comment '角色名称',
   R_Description        national varchar(255) comment '角色介绍',
   R_RoleCode           varchar(20),
   primary key (RoleID)
);

alter table sys_Roles comment '角色表';

/*==============================================================*/
/* Table: sys_SystemInfo                                        */
/*==============================================================*/
create table sys_SystemInfo
(
   SystemID             varchar(40) not null comment '自动ID',
   S_Name               national varchar(50) comment '系统名称',
   S_Version            national varchar(50) comment '版本号',
   S_SystemConfigData   longblob comment '系统配置信息',
   S_Licensed           varchar(50) comment '序列号',
   primary key (SystemID)
);

alter table sys_SystemInfo comment '系统信息表';

/*==============================================================*/
/* Table: sys_User                                              */
/*==============================================================*/
create table sys_User
(
   UserID               varchar(40) not null comment '用户ID号',
   U_LoginName          national varchar(20) not null comment '登陆名',
   U_Password           varchar(100) not null comment '密码md5加密字符',
   U_CName              national varchar(20) comment '中文姓名',
   U_EName              varchar(50) comment '英文名',
   U_GroupID            varchar(40) not null comment '部门ID号与sys_Group表中GroupID关联',
   U_Email              varchar(100) comment '电子邮件',
   U_Type               tinyint not null default 1 comment '用户类型0:超级用户1:普通用户',
   U_Status             tinyint not null default 1 comment '当前状态0:正常 1:禁止登陆 2:删除',
   U_Licence            varchar(30) comment '用户序列号',
   U_Mac                varchar(50) comment '锁定机器硬件地址',
   U_Remark             national varchar(200) comment '备注说明',
   U_IDCard             varchar(30) comment '身份证号码',
   U_Sex                tinyint comment '性别1:男0:女',
   U_BirthDay           datetime comment '出生日期',
   U_MobileNo           varchar(15) comment '手机号',
   U_UserNO             varchar(20) comment '员工编号',
   U_WorkStartDate      datetime comment '到职日期',
   U_WorkEndDate        datetime comment '离职日期',
   U_CompanyMail        varchar(255) comment '公司邮件地址',
   U_Title              varchar(40) comment '职称与应用字段关联',
   U_Extension          varchar(10) comment '分机号',
   U_HomeTel            varchar(20) comment '家中电话',
   U_PhotoUrl           national varchar(255) comment '用户照片网址',
   U_DateTime           datetime comment '操作时间',
   U_LastIP             varchar(15) comment '最后访问IP',
   U_LastDateTime       datetime comment '最后访问时间',
   U_ExtendField        longblob comment '扩展字段',
   primary key (UserID)
);

alter table sys_User comment '用户表';

/*==============================================================*/
/* Table: sys_UserRoles                                         */
/*==============================================================*/
create table sys_UserRoles
(
   R_UserID             varchar(40) not null comment '用户ID与sys_User表中UserID相关',
   R_RoleID             varchar(40) not null comment '用户所属角色ID与Sys_Roles关联',
   primary key (R_UserID, R_RoleID)
);

alter table sys_UserRoles comment '用户角色表';

