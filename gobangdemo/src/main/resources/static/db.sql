create database if not exists java_gobang;
use java_gobang;

drop table if exists user;
create table user (
    -- id
    uid int primary key auto_increment,
    -- 用户名
    username varchar(50) unique ,
    -- 密码
    password varchar(50),
    -- 战绩
    score int,
    -- 对战场数
    toralCount int,
    -- 获胜场数
    winCount int
);

insert into user values(null, 'zhangsan', '122333', 111, 22, 2);
insert into user values(null, 'lisi', '1223', 11, 2, 0);
insert into user values(null, 'wangwu', '122333', 1122, 222,92);
insert into user values(null, 'wwww', '122333', 1211, 2222, 542);