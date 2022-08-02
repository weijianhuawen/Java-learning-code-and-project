-- 图书名称，图书作者、图书价格、图书分类
create table Books (name varchar(20), author varchar(20), price decimal(5,2), class varchar(20));

-- 在图书表中新增一条记录：Java核心技术、作者“Cay S. Horstman”，价格56.43，分类为“计算机技术”
insert into Books values ("Java核心技术", "Cay S. Horstman", 56.43, "计算机技术");

-- 修改“Java核心技术”的图书信息，将价格修改为61
update Books set price=61 where name="Java核心技术";

-- 查询book图书表中，作者author列不为空，或者满足条件：价格price在50元以上且出版日期publish_date在2019年之后的图书信息
create table book (name varchar(20), author varchar(20), price decimal(5,2), class varchar(20), publish_date datetime);

insert into book values ("Java核心技术", "Cay S. Horstman", 56.43, "计算机技术", "2019-09-09"),
                        ("计算机操作系统", "匿名", 43.56, "计算机技术", "2020-02-02");

select * from book where author is not null and price>=50 and publish_date>="2019-01-01";

-- 设计一张老师表，包含以下字段：姓名、年龄、身高、体重、性别、学历、生日、身份证号
create table Teacher (
    name varchar(20),
    age int,
    height decimal(3, 2),
    weight decimal(5, 2),
    sex varchar(2),
    education varchar(10),
    birthday datetime,
    idCard varchar(20) primary key
                     );


-- 设计一张商品表，包含以下字段：商品名称、商品价格、商品库存、商品描述
create table commodity (
    name varchar(50),
    price decimal(11, 2),
    stock int,
    descCom varchar(100));

-- 在以上创建的商品表中插入一条数据：名称为“学生书包”、价格18.91、库存101、描述为空
insert into commodity values ("学生书包", 18.91, 101, null);

-- 修改所有库存大于30的商品记录，将价格增加50块
update commodity set price=price+50 where stock >=30;

-- 删除商品表中，价格大于60，或者是库存小于200的记录
delete from commodity where price > 60 or stock < 200;

-- student学生表中，字段有姓名name，年龄age，要求查询姓张，并且年龄在18到25岁之间的学生
create table student (
    id int primary key auto_increment,
    name varchar(20),
    age int
);

insert into student (name, age) values ("张三", 20), ("李四", 19), ("王五", 21), ("赵子龙", 23), ("张同学", 18), ("张大炮", 21);

select * from student where name like "张%" and age >= 18 and age <= 25;

-- 查询article文章表中，发表日期create_date在2019年1月1日上午10点30分至2019年11月10日下午4点2分的文章
create table article (name varchar(20), create_date datetime, article_desc varchar(100));

insert into article values ("计算机组成原理详解", "2019-02-22 22:22", "计算机"),
    ("C语言指针详解", "2019-10-11 21:21", "c语言程序设计"),
    ("Java面向对象详解", "2019-12-12 19:19", "javayyds");

select * from article where create_date between "2019-01-01 10:30" and "2019-11-10 04:02";


insert into article values (null, "2016-05-03 23:11", "未知"), ("MySQL增删查改", "2022-03-16 12:00", "mysql基础入门");
select * from article where name is null or create_date >= "2019-01-01";



-- 查询用户user表中，满足以下条件的用户数据：
--
--
--
-- 1. ID在1至200或300至500，且账号accout列不为空
--
-- 2. 充值金额amount在1000以上。

create table user (id int primary key auto_increment, account varchar(20) not null, amount decimal(11, 2));

insert into user values (52, "20220052", 1000), (53, "20220053", 220), (54, "20220054", 400),
                        (55, "20220055", 112), (56, "20220056", 20), (57, "20220057", 12300),
                        (58, "20220058", 30), (59, "20220059", 6), (60, "20220060", 1314),
                        (320, "20220320", 0), (321, "20220321", 1004), (322, "20220322", 10),
                        (388, "20220388", 9000), (414, "20220414", 68), (401, "20220401", 100),
                        (520, "20220520", 520), (521, "20220521", 22), (522, "20220522", 48),
                        (588, "20220588", 420), (598, "2022098", 1999), (599, "20220599", 2304),
                        (666, "20220666", 0), (777, "20220777", 1277), (888, "20220888", 188);

select * from user where (id between 1 and 200 or id between 300 and 500) and account is not null and amount >= 1000;



-- 学校食堂管理系统，包含食堂表，食堂仓口表，仓口收费记录表
create database canteens;

use canteens;
-- 食堂表 食堂id 食堂名称 食堂地址 食堂管理员
create table canteen (id int primary key, name varchar(20), address varchar(50), administrator varchar(20));
-- 食堂仓口表 窗口id 窗口名称 窗口负责人  所处食堂id
create table canteenWin (win_id int,
                        name varchar(20),
                        leadPeraon varchar(20),
                        can_id int,
                        foreign key (can_id) references canteen(id));
-- 仓口收费记录表 消费者卡号 消费者姓名 消费金额 消费窗口id 消费食堂id
create table charge (consumer_id int,
                    consumer_name varchar(20),
                    charge_price decimal(6, 2),
                    win_id int,
                    can_id int,
                    constraint charge_win foreign key (can_id) references canteen(id));


-- 建表时创建外键
constraint 外键名 foreign key (子表字段) references 父表名(父表字段);
-- 建表是创建多个外键约束
foreign key (子表字段) references 父表名(父表字段), foreign key (子表字段) references 父表名(父表字段), ...;
-- 建表后创建外键
alter table 子表名 add constraint 外键名 foreign key (子表字段) references 父表名(父表字段);
-- 删除外键
alter table 子表名 drop foreign key 外键约束名;

-- 车辆违章系统，包含用户表，车辆表，违章信息表。违章信息表中包含用户和车辆的违章信息
create database vehicle;
use vehicle;

-- 用户表 身份证号 姓名
create table user
(
    id int primary key,
    name varchar(20)
);

-- 车辆表 车牌号 汽车型号 违章者id
create table car
(
    car_id int primary key,
    car_name varchar(20),
    user_id int,
    foreign key(user_id) references user(id)
);
-- 违章信息表 违章信息id 违章者身份证 违章车牌号

create table volition
(
    vio_id int primary key,
    user_id int,
    car_id int,
    foreign key(user_id) references user(id),
    foreign key(car_id) references car(car_id)
);

-- 学校宿舍管理系统，要求包含宿舍信息，学生信息，每日的宿舍查房记录。
create database dormitory;
use dormitory;

-- 宿舍 宿舍id 宿舍名称 宿舍地址
create table dorm
(
    id int primary key,
    name varchar(20),
    address varchar(50)
);
-- 学生 id name class dorm_id
create table student
(
    id int,
    name varchar(20),
    class_id int,
    dorm_id int,
    foreign key(dorm_id) references dorm(id)
);

-- 登记信息 register 查寝id 查寝寝室id 查寝时间 记录
create table register
(
    id int primary key,
    dorm_id int,
    time datetime,
    record varchar(20),
    foreign key (dorm_id) references dorm(id)
);

-- 考勤系统，包含员工表，考勤记录表
create database attendance;
use attendance;


-- 员工表
create table emp(
    id int primary key,
    name varchar(20));

-- 考勤记录 考勤id 是否考勤 考勤者id 考勤记录
create table attending (
  id int primary key,
  isAttend bit,
  emp_id int,
  register datetime,
  foreign key(emp_id) references emp(id));