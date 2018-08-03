/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/8/2 14:36:22                            */
/*==============================================================*/


drop table if exists Role;

drop table if exists permission;

drop table if exists role_x_permission;

drop table if exists user;

drop table if exists user_x_role;

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role
(
   id                   bigint not null auto_increment,
   role                 varchar(20) not null,
   description          varchar(20),
   available            bool,
   primary key (id)
);

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   id                   bigint not null auto_increment,
   permission           varchar(20) not null,
   description          varchar(20),
   available            bool,
   primary key (id)
);

/*==============================================================*/
/* Table: role_x_permission                                     */
/*==============================================================*/
create table role_x_permission
(
   role_id              bigint,
   permission_id        bigint
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   bigint not null auto_increment,
   username             varchar(20) not null,
   password             varchar(20) not null,
   salt                 varchar(20),
   locked               bool,
   primary key (id)
);

/*==============================================================*/
/* Table: user_x_role                                           */
/*==============================================================*/
create table user_x_role
(
   user_id              bigint,
   role_id              bigint
);

alter table role_x_permission add constraint FK_Reference_3 foreign key (role_id)
      references Role (id) on delete restrict on update restrict;

alter table role_x_permission add constraint FK_Reference_4 foreign key (permission_id)
      references permission (id) on delete restrict on update restrict;

alter table user_x_role add constraint FK_Reference_1 foreign key (user_id)
      references user (id) on delete restrict on update restrict;

alter table user_x_role add constraint FK_Reference_2 foreign key (role_id)
      references Role (id) on delete restrict on update restrict;

