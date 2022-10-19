-- 创建数据库
drop database if exists musicserve;
create database if not exists musicserve character set utf8mb4;

-- 使用数据库
use musicserve;

-- 用于用户登录的表
drop table if exists userlogin;
create table userlogin (
    -- 用户id
    uid int primary key auto_increment,
    -- 账号名
    username varchar(32) not null,
    -- 密码
    password varchar(512) not null
);

insert into userlogin values(null, 'wjhw', '123456');
-- 用户信息表
drop table if exists usermessage;
create table usermessage (
    -- 用户id
    uid int,
    -- 性别
    sex varchar(4),
    -- 昵称
    netname varchar(20) not null ,
    -- 生日
    birthday date,
    -- 邮箱
    email varchar(128),
    -- 手机号
    phone varchar(32),
    -- 头像
    head_image varchar(256),
    -- 保留字段A
    region varchar(128),
    -- 保留字段B
    none varchar(64),
    -- 外键约束
    foreign key(uid) references userlogin(uid)
);

-- 音乐表
drop table if exists music;
create table music (
    -- id
    mid int primary key auto_increment,
    -- 音乐标题
    title varchar(64) NOT NULL,
    -- 音乐歌手
    singer varchar(32) NOT NULL,
    time varchar(32) NOT NULL,
    url varchar(1024) NOT NULL,
    userid int(16) NOT NULL
);

DROP TABLE IF EXISTS lovemusic;
CREATE TABLE lovemusic (
    id int PRIMARY KEY AUTO_INCREMENT,
    user_id int(11) NOT NULL,
    music_id int(11) NOT NULL
);

insert into userlogin(username, password) values('whh2','$2a$10$clGgugqTHprvUxpfxaTWGe8yPBbFX4tWheTfkWY1URZjLthD4amt2');

insert into userlogin(username, password) values('whh1','123456');