package test;

import model.Student;
import model.Students;

import java.util.ArrayList;
import java.util.List;

public class TestFunc {
    public static void testStudent(){
        Student student1 = new Student("2020001", "张三", "男", "2020", "软件工程", "软件2011");
        Student student2 = new Student("2020002", "李四", "男", "2020", "软件工程", "软件2011");
        Student student3 = new Student("2020003", "王五", "男", "2020", "软件工程", "软件2011");
        Student student4 = new Student("2020004", "赵六", "男", "2020", "软件工程", "软件2011");
        Student student5 = new Student("2020005", "李七", "男", "2020", "软件工程", "软件2011");
        Student student6 = new Student("2020006", "王八", "男", "2020", "软件工程", "软件2011");
        Student student7 = new Student("2020007", "陈九", "男", "2020", "软件工程", "软件2011");
        Student student8 = new Student("2020008", "吴十", "男", "2020", "软件工程", "软件2011");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Students sadmin = new Students(students);
        //增
        sadmin.add(student6);
        sadmin.add(student7);
        sadmin.add(student8);
        System.out.println(sadmin);
        //查
        System.out.println(sadmin.search("2020002"));
        //储存在最后的同学
        System.out.println(sadmin.tail.val);
        //改名字 以张三为例
        System.out.println("修改名字");
        System.out.println("修改前:" + sadmin.search("2020001").name);
        sadmin.setName("2020001", "张大炮");
        System.out.println("修改后:" + sadmin.search("2020001").name);

        System.out.println("修改专业");
        System.out.println("修改前:" + sadmin.search("2020001").major);
        sadmin.setMajor("2020001", "计算机科学与技术");
        System.out.println("修改后:" + sadmin.search("2020001").major);


        System.out.println("修改班级");
        System.out.println("修改前:" + sadmin.search("2020001").c);
        sadmin.setClass("2020001", "计算2011");
        System.out.println("修改后:" + sadmin.search("2020001").c);

        System.out.println(sadmin.search("2020001"));

        //删除这位张大炮同学(张三) 学号为2020001 还有学号为2020005 2020008的同学
        sadmin.remove("2020001");
        sadmin.remove("2020005");
        sadmin.remove("2020008");
        System.out.println(sadmin);
    }

    public static void main(String[] args) {
        testStudent();
    }
}
