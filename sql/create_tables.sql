-- auto-generated definition
create table user
(
    id           bigint auto_increment comment '用户id'
        primary key,
    username     varchar(256)                       null comment '用户名',
    userAccount  varchar(256)                       null comment '用户账号',
    avatarUrl    varchar(1024)                      null comment '用户头像',
    gender       tinyint                            null comment '用户性别',
    userPassword varchar(512)                       not null comment '用户密码',
    tags         varchar(1024)                      null comment '标签列表',
    phone        varchar(128)                       null comment '联系方式',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 not null comment '用户状态',
    createTime   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint  default 0                 not null comment '是否删除',
    userRole     tinyint  default 0                 not null comment '用户权限',
    profile      varchar(512)                       null comment '个人简介'
) comment '用户';



create table tag
(
    id         bigint auto_increment comment '标签 id'
        primary key,
    tagName    varchar(256)                       null comment '标签名称',
    userId     bigint                             null comment '用户 id',
    parentId   bigint                             null comment '父标签 id',
    isParent   tinyint                            null comment '0 - 不是，1 - 父标签',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    constraint uniIdx_tagName
        unique (tagName)
) comment '标签';

create index idx_userId
    on tag (userId);

create table team
(
    id           bigint auto_increment comment '队伍id'
        primary key,
    name         varchar(256)                       not null comment '队伍名称',
    description  varchar(1024)                      null comment '描述',
    maxNum       int      default 1                 not null comment '最大人数',
    expireTime   datetime                           null comment '过期时间',
    userId       bigint                             not null comment '用户id',
    status       int      default 0                 not null comment '0 - 公开, 1 - 私有, 2 - 加密',
    password     varchar(512)                       null comment '密码',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint  default 0                 not null comment '是否删除'
) comment '队伍';

create table user_team
(
    id           bigint auto_increment comment '队伍id'
        primary key,
    userId       bigint                             not null comment '用户id',
    teamId       bigint                             not null comment '队伍id',
    expireTime   datetime                           not null comment '过期时间',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint  default 0                 not null comment '是否删除'
) comment '用户队伍关系';