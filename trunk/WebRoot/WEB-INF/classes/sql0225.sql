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

alter table biz_News comment '��������';

/*==============================================================*/
/* Table: sys_Applications                                      */
/*==============================================================*/
create table sys_Applications
(
   ApplicationID        varchar(40) not null comment '�Զ�ID 1:Ϊϵͳ����Ӧ��',
   A_AppName            national varchar(50) comment 'Ӧ������',
   A_AppDescription     national varchar(200) comment 'Ӧ�ý���',
   A_AppUrl             varchar(50) comment 'Ӧ��Url��ַ',
   A_Order              int comment 'Ӧ������',
   primary key (ApplicationID)
);

alter table sys_Applications comment 'Ӧ�ñ�';

/*==============================================================*/
/* Table: sys_Event                                             */
/*==============================================================*/
create table sys_Event
(
   EventID              varchar(40) not null comment '�¼�ID��',
   E_U_LoginName        national varchar(20) comment '�û���',
   E_UserID             varchar(40) comment '����ʱ�û�ID��sys_Users��UserID',
   E_DateTime           datetime not null comment '�¼����������ڼ�ʱ��',
   E_ApplicationID      varchar(40) comment '����Ӧ�ó���ID��sys_Applicatio',
   E_A_AppName          national varchar(50) comment '����Ӧ������',
   E_M_Name             national varchar(50) comment 'PageCodeģ��������sys_Module��ͬ',
   E_M_PageCode         varchar(6) comment '�����¼�ʱģ������',
   E_From               national varchar(500) comment '��Դ',
   E_Type               tinyint not null default 1 comment '�ռ�����,1:�����ռ�2:��ȫ��־3',
   E_IP                 varchar(15) comment '�ͻ���IP��ַ',
   E_Record             national varchar(500) comment '��ϸ����',
   primary key (EventID)
);

alter table sys_Event comment 'ϵͳ�ռǱ�';

/*==============================================================*/
/* Table: sys_Field                                             */
/*==============================================================*/
create table sys_Field
(
   FieldID              varchar(40) not null comment 'Ӧ���ֶ�ID��',
   F_Key                varchar(50) comment 'Ӧ���ֶιؼ���',
   F_CName              national varchar(50) comment 'Ӧ���ֶ�����˵��',
   F_Remark             national varchar(200) comment '����˵��',
   primary key (FieldID)
);

alter table sys_Field comment 'ϵͳӦ���ֶ�';

/*==============================================================*/
/* Table: sys_FieldValue                                        */
/*==============================================================*/
create table sys_FieldValue
(
   ValueID              varchar(40) not null comment '����ID��',
   V_F_Key              varchar(50) comment '��sys_Field����F_Key�ֶι���',
   V_Text               national varchar(100) comment '����˵��',
   V_Code               varchar(100) comment '����',
   V_ShowOrder          int not null default 0 comment 'ͬ����ʾ˳��',
   primary key (ValueID)
);

alter table sys_FieldValue comment 'Ӧ���ֶ�ֵ';

/*==============================================================*/
/* Table: sys_Group                                             */
/*==============================================================*/
create table sys_Group
(
   GroupID              varchar(40) not null comment '����ID��',
   G_CName              national varchar(50) comment '��������˵��',
   G_ParentID           varchar(40) not null default '0' comment '�ϼ�����ID0:Ϊ��߼�',
   G_ShowOrder          int not null default 0 comment '��ʾ˳��',
   G_Level              int comment '��ǰ�������ڲ���',
   G_ChildCount         int comment '��ǰ�����ӷ�����',
   G_Delete             tinyint comment '�Ƿ�ɾ��1:��0:��',
   primary key (GroupID)
);

alter table sys_Group comment '����';

/*==============================================================*/
/* Table: sys_Module                                            */
/*==============================================================*/
create table sys_Module
(
   ModuleID             varchar(40) not null comment '����ģ��ID��',
   M_ApplicationID      varchar(40) not null comment '����Ӧ�ó���ID',
   M_ParentID           varchar(40) not null comment '��������ģ��ID��ModuleID����,0Ϊ����',
   M_PageCode           varchar(6) not null comment 'ģ�����ParentΪ0,��ΪS00(xx),����ΪS00M00(xx)',
   M_CName              national varchar(50) comment 'ģ��/��Ŀ���Ƶ�ParentIDΪ0Ϊģ������',
   M_Directory          national varchar(255) comment 'ģ��/��ĿĿ¼��',
   M_OrderLevel         varchar(4) comment '��ǰ�������򼶱�֧��˫��99���˵�',
   M_IsSystem           tinyint comment '�Ƿ�Ϊϵͳģ��1:��0:����Ϊϵͳ���޷��޸�',
   M_Close              tinyint comment '�Ƿ�ر�1:��0:��',
   M_Icon               varchar(255) comment 'ģ��Icon',
   primary key (ModuleID)
);

alter table sys_Module comment '����ģ��';

/*==============================================================*/
/* Table: sys_ModuleExtPermission                               */
/*==============================================================*/
create table sys_ModuleExtPermission
(
   ExtPermissionID      varchar(40) not null comment '��չȨ��ID',
   ModuleID             varchar(40) not null comment 'ģ��ID',
   PermissionName       national varchar(100) not null comment 'Ȩ������',
   PermissionValue      int not null comment 'Ȩ��ֵ',
   primary key (ModuleID, PermissionValue)
);

alter table sys_ModuleExtPermission comment 'ģ����չȨ��';

/*==============================================================*/
/* Table: sys_Online                                            */
/*==============================================================*/
create table sys_Online
(
   OnlineID             varchar(40) not null comment '�Զ�ID',
   O_SessionID          varchar(24) not null comment '�û�SessionID',
   O_UserName           national varchar(20) not null comment '�û���',
   O_Ip                 varchar(15) not null comment '�û�IP��ַ',
   O_LoginTime          datetime not null comment '��½ʱ��',
   O_LastTime           datetime not null comment '������ʱ��',
   O_LastUrl            national varchar(500) not null comment '���������վ',
   primary key (O_SessionID)
);

alter table sys_Online comment '�����û���';

/*==============================================================*/
/* Table: sys_RoleApplication                                   */
/*==============================================================*/
create table sys_RoleApplication
(
   A_RoleID             varchar(40) not null comment '��ɫID��sys_Roles��RoleID���',
   A_ApplicationID      varchar(40) not null comment 'Ӧ��ID��sys_Applications��Appl',
   primary key (A_RoleID, A_ApplicationID)
);

alter table sys_RoleApplication comment '��ɫӦ�ñ�';

/*==============================================================*/
/* Table: sys_RolePermission                                    */
/*==============================================================*/
create table sys_RolePermission
(
   PermissionID         varchar(40) not null comment '��ɫӦ��Ȩ���Զ�ID',
   P_RoleID             varchar(40) not null comment '��ɫID��sys_Roles����RoleID��',
   P_ApplicationID      varchar(40) not null comment '��ɫ����Ӧ��ID��sys_Applicatio',
   P_PageCode           varchar(20) not null comment '��ɫӦ����ҳ��Ȩ�޴���',
   P_Value              int comment 'Ȩ��ֵ',
   primary key (P_RoleID, P_ApplicationID, P_PageCode)
);

alter table sys_RolePermission comment '��ɫӦ��Ȩ�ޱ�';

/*==============================================================*/
/* Table: sys_Roles                                             */
/*==============================================================*/
create table sys_Roles
(
   RoleID               varchar(40) not null comment '��ɫID�Զ�ID',
   R_UserID             varchar(40) not null comment '�ǽ������û�ID',
   R_RoleName           national varchar(50) not null comment '��ɫ����',
   R_Description        national varchar(255) comment '��ɫ����',
   R_RoleCode           varchar(20),
   primary key (RoleID)
);

alter table sys_Roles comment '��ɫ��';

/*==============================================================*/
/* Table: sys_SystemInfo                                        */
/*==============================================================*/
create table sys_SystemInfo
(
   SystemID             varchar(40) not null comment '�Զ�ID',
   S_Name               national varchar(50) comment 'ϵͳ����',
   S_Version            national varchar(50) comment '�汾��',
   S_SystemConfigData   longblob comment 'ϵͳ������Ϣ',
   S_Licensed           varchar(50) comment '���к�',
   primary key (SystemID)
);

alter table sys_SystemInfo comment 'ϵͳ��Ϣ��';

/*==============================================================*/
/* Table: sys_User                                              */
/*==============================================================*/
create table sys_User
(
   UserID               varchar(40) not null comment '�û�ID��',
   U_LoginName          national varchar(20) not null comment '��½��',
   U_Password           varchar(100) not null comment '����md5�����ַ�',
   U_CName              national varchar(20) comment '��������',
   U_EName              varchar(50) comment 'Ӣ����',
   U_GroupID            varchar(40) not null comment '����ID����sys_Group����GroupID����',
   U_Email              varchar(100) comment '�����ʼ�',
   U_Type               tinyint not null default 1 comment '�û�����0:�����û�1:��ͨ�û�',
   U_Status             tinyint not null default 1 comment '��ǰ״̬0:���� 1:��ֹ��½ 2:ɾ��',
   U_Licence            varchar(30) comment '�û����к�',
   U_Mac                varchar(50) comment '��������Ӳ����ַ',
   U_Remark             national varchar(200) comment '��ע˵��',
   U_IDCard             varchar(30) comment '���֤����',
   U_Sex                tinyint comment '�Ա�1:��0:Ů',
   U_BirthDay           datetime comment '��������',
   U_MobileNo           varchar(15) comment '�ֻ���',
   U_UserNO             varchar(20) comment 'Ա�����',
   U_WorkStartDate      datetime comment '��ְ����',
   U_WorkEndDate        datetime comment '��ְ����',
   U_CompanyMail        varchar(255) comment '��˾�ʼ���ַ',
   U_Title              varchar(40) comment 'ְ����Ӧ���ֶι���',
   U_Extension          varchar(10) comment '�ֻ���',
   U_HomeTel            varchar(20) comment '���е绰',
   U_PhotoUrl           national varchar(255) comment '�û���Ƭ��ַ',
   U_DateTime           datetime comment '����ʱ��',
   U_LastIP             varchar(15) comment '������IP',
   U_LastDateTime       datetime comment '������ʱ��',
   U_ExtendField        longblob comment '��չ�ֶ�',
   primary key (UserID)
);

alter table sys_User comment '�û���';

/*==============================================================*/
/* Table: sys_UserRoles                                         */
/*==============================================================*/
create table sys_UserRoles
(
   R_UserID             varchar(40) not null comment '�û�ID��sys_User����UserID���',
   R_RoleID             varchar(40) not null comment '�û�������ɫID��Sys_Roles����',
   primary key (R_UserID, R_RoleID)
);

alter table sys_UserRoles comment '�û���ɫ��';

