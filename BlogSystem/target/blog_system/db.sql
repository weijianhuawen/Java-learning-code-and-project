-- 建数据库
create database if not exists blog_system;
-- 选中数据库
use blog_system;

-- 建表
-- 博客表
drop table if exists blog;
create table blog (
    blogId int primary key auto_increment,
    title varchar(1024),
    content mediumtext,
    userId int,
    postTime datetime
);

-- 用户表
drop table if exists user;
create table user (
    userId int primary key auto_increment,
    username varchar(128) unique,
    password varchar(128)
);

insert into user values (null, "张三","123456");
insert into user values (null, "李四","123123");
insert into user values (null, "未见花闻","123");
insert into blog values(null, "第一篇博客", "这是我的第一篇博客，我要认真学习java......", 1, now());
insert into blog values(null, "第二篇博客", "这是我的第二篇博客，我要认真学习java......", 1, now());
insert into blog values(null, "第三篇博客", "这是我的第三篇博客，我要认真学习java......", 1, now());
insert into blog values(null, "第一篇博客", "这是我的第一篇博客，我要认真学习php......", 2, now());
insert into blog values(null, "第二篇博客", "这是我的第二篇博客，我要认真学习c++......", 2, now());
-- 建数据库
create database if not exists message_wall;
-- 选中数据库
use message_wall;
drop table if exists message;
-- 建表
create table message (
    `from` varchar(1024),
    `to` varchar(1024),
    message varchar(4096),
    romadv varchar(1024)
);
