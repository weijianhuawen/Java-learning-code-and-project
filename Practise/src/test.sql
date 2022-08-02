
drop table if exists classes;
drop table if exists student;
drop table if exists course;
drop table if exists score;

create table classes (id int primary key auto_increment, name varchar(20), `desc` varchar(100));

create table student (id int primary key auto_increment, sn varchar(20),  name varchar(20), email varchar(20) ,
                      classes_id int);

create table course(id int primary key auto_increment, name varchar(20));

create table score(score decimal(3, 1), student_id int, course_id int);

insert into classes(name, `desc`) values
                                      ('计算机系2020级1班', '学习了计算机原理、C和Java语言、数据结构和算法'),
                                      ('中文系2020级3班','学习了中国传统文学'),
                                      ('自动化2020级5班','学习了机械自动化'),
                                      ('数学系2020级2班' , '学习了数学分析'),
                                      ('化学系2020级4班' , '学习了有机化学，无机化学，物理化学'),
                                      ('生物系2020级6班', '学习了生物学');

insert into student(sn, name, email, classes_id) values
                                                       ('2020001','喜羊羊','xyy@163.com',1),
                                                       ('2020002','美羊羊','myy@163.com',1),
                                                       ('2020003','沸羊羊','fyy@163.com',1),
                                                       ('2020004','懒羊羊','lyy@163.com',2),
                                                       ('2020005','花羊羊',null,2),
                                                       ('2020006','慢羊羊','yjyj@163.com',6),
                                                       ('2020007','小灰灰',null,2),
                                                       ('2020008','希儿','nzdxierl@163.com',2),
                                                       ('2020009','布洛尼亚','zzxt@163.com',3),
                                                       ('2020010','光头强','wyfc@163.com',3),
                                                       ('2020011','黑大帅','wwzz@163.com',3),
                                                       ('2020012','开心超人','kxcr@163.com',4),
                                                       ('2020013','刻晴','zjnz@163.com',4),
                                                       ('2020014','可莉','nslzknwdm@163.com',5),
                                                       ('2020015','万叶','lypl@163.com',5),
                                                       ('2020016','胡桃','ylzh@163.com',6);

insert into course(name) values
                             ('Java'),('中国传统文化'),('计算机原理'),('汉语言文学'),('高等数学'),('英语'),
                             ('大学物理'),('有机化学'),('生物学'),('数学分析'),('无机化学'),('机械制图');

insert into score(score, student_id, course_id) values
-- 喜羊羊
(90.5, 1, 1),(98.5, 1, 3),(93, 1, 5),(88, 1, 6),
-- 美羊羊
(88, 2, 1), (78.5, 2, 3), (94.5, 2, 5), (98, 2, 6),
-- 沸羊羊
(63, 3, 1),(68, 3, 3),(79, 3, 5),
-- 懒羊羊
(67, 4, 2),(23, 4, 4), (72, 4, 6),
-- 花羊羊
(81, 5, 2),(90, 5, 6),
-- 慢羊羊
(87, 6, 7),(90, 6, 9),(89, 6, 5),
-- 小灰灰
(80, 7, 2),(92, 7, 6),
-- 希儿
(89, 8, 2),(78, 8, 6),
-- 布洛尼亚
(82, 9, 7), (98, 9, 12),
-- 光头强
(70, 10, 7), (81, 10, 12),
-- 黑大帅
(88, 11, 1), (90, 11, 5), (72, 11, 12),
-- 开心超人
(61, 12, 6), (87, 12, 10),
-- 刻晴
(90, 13, 2), (88, 13, 10),
-- 可莉
(58, 14, 5), (72, 14, 8), (78, 14, 11),
-- 万叶
(90, 15, 5), (82, 15, 8), (91, 15, 11),
-- 胡桃
(99, 16, 2), (73, 16, 5), (89, 16, 9);
