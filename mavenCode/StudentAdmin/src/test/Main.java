package test;

import model.*;
import ui.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void setStu(Students students){
        Scanner sc = new Scanner(System.in);
        Menu m = new Menu();
        int input = 0;
        do {
            m.menu3();
            System.out.print("请输入功能序号->");
            input = sc.nextInt();
            sc.nextLine();
            if (input == -1) {
                System.out.println("退出修改！");
                break;
            }
            System.out.print("请输入需要修改的学号->");
            String id = sc.nextLine();

            switch (input) {
                case 1:
                    System.out.print("请输入修改后姓名->");
                    String name = sc.nextLine();
                    if (students.setName(id, name)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                case 2:
                    System.out.print("请输入修改后性别->");
                    String sex = sc.nextLine();
                    if (students.setSex(id, sex)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                case 3:
                    System.out.print("请输入修改后年级->");
                    String join = sc.nextLine();
                    if (students.setJoin(id, join)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                case 4:
                    System.out.print("请输入修改后专业->");
                    String major = sc.nextLine();
                        if (students.setMajor(id, major)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                case 5:
                    System.out.print("请输入修改后班级->");
                    String c = sc.nextLine();
                    if (students.setMajor(id, c)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                default:
                    System.out.println("输入不合法，请重新输入！");
                    break;
            }
        } while (true);
    }
    public static void insertStu(Students students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生信息:");
        System.out.println("请输入学生学号:");
        String id = sc.nextLine();
        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();
        System.out.println("请输入学生性别:");
        String sex = sc.nextLine();
        System.out.println("请输入学生入学年份:");
        String join = sc.nextLine();
        System.out.println("请输入学生专业:");
        String major = sc.nextLine();
        System.out.println("请输入学生班级:");
        String c = sc.nextLine();
        Student student = new Student(id, name, sex, join, major, c);
        if (students.add(student)){
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
    }
    public static void removeStu(Students students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生id:");
        String sid = sc.nextLine();
        Student stu = students.remove(sid);
        if (stu != null) {
            System.out.println("删除成功!删除的学生姓名为:"+ stu.name);
        } else {
            System.out.println("删除失败!");
        }
    }
    public static void insertCour(Courses courses) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入课程信息:");
        System.out.println("请输课程编号:");
        String id = sc.nextLine();
        System.out.println("请输入课程名称:");
        String name = sc.nextLine();
        System.out.println("请输入课程性质:");
        String nature = sc.nextLine();
        System.out.println("请输入课程类别:");
        String c = sc.nextLine();
        System.out.println("请输入课程学分:");
        int credit = sc.nextInt();
        sc.nextLine();
        System.out.println("请输入开课学期:");
        String semester = sc.nextLine();
        Course course = new Course(id, name, nature, c, credit, semester);
        if (courses.add(course)){
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
    }
    public static void removeCour(Courses courses) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的课程id:");
        String cid = sc.nextLine();
        Course cou = courses.remove(cid);
        if (cou != null) {
            System.out.println("删除成功!删除的课程名称为:"+ cou.courseName);
        } else {
            System.out.println("删除失败!");
        }
    }
    public static void stuadmin(Students students){
        Scanner sc = new Scanner(System.in);
        Menu m = new Menu();
        int n = 0;
        do {
            m.menu2();
            System.out.print("请输入功能序号->");
            n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1 :
                    insertStu(students);
                    break;
                case 2:
                    removeStu(students);
                    break;
                case 3:
                    setStu(students);
                    break;
                case 4:
                    showStu(students);
                    break;
                case -1:
                    System.out.println("退出学生信息管理成功!");
                    break;
                default:
                    System.out.println("输入不合法，请重新输入！");
                    break;
            }
        } while (n != -1);
    }
    private static void showStu(Students students){
        System.out.println(students);
        Students.StudentNode cur = students.head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void setCour(Courses courses) {
        Scanner sc = new Scanner(System.in);
        Menu m = new Menu();
        int input = 0;
        do {
            m.menu5();
            System.out.print("请输入功能序号->");
            input = sc.nextInt();
            sc.nextLine();
            if (input == -1) {
                System.out.println("退出修改！");
                break;
            }
            System.out.print("请输入需要修改的课程号->");
            String id = sc.nextLine();

            switch (input) {
                case 1:
                    System.out.print("请输入修改后课程名称->");
                    String name = sc.nextLine();
                    if (courses.setName(id, name)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                case 2:
                    System.out.print("请输入修改后课程性质->");
                    String nature = sc.nextLine();
                    if (courses.setNature(id, nature)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                case 3:
                    System.out.print("请输入修改后课程类别->");
                    String c = sc.nextLine();
                    if (courses.setClass(id, c)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                case 4:
                    System.out.print("请输入修改后课程学分->");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    if (courses.setCredit(id, credit)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                case 5:
                    System.out.print("请输入修改后开课学期->");
                    String semester = sc.nextLine();
                    if (courses.setSemester(id, semester)) {
                        System.out.println("修改成功!");
                    } else {
                        System.out.println("修改失败!");
                    }
                    break;
                default:
                    System.out.println("输入不合法，请重新输入！");
                    break;
            }
        } while (true);
    }
    private static void showCour(Courses courses) {
        System.out.println(courses);
        List<Course> list = courses.courses;
        for (Course x : list) {
            System.out.println(x);
        }
    }
    public static void courseadmin(Courses courses){
        Scanner sc = new Scanner(System.in);
        Menu m = new Menu();
        int n = 0;
        do {
            m.menu4();
            System.out.print("请输入功能序号->");
            n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1 :
                    insertCour(courses);
                    break;
                case 2:
                    removeCour(courses);
                    break;
                case 3:
                    setCour(courses);
                    break;
                case 4:
                    showCour(courses);
                    break;
                case -1:
                    System.out.println("退出课程管理成功!");
                    break;
                default:
                    System.out.println("输入不合法，请重新输入！");
                    break;
            }
        } while (n != -1);
    }
    public static void CourseScoreInput(Scores scores, Courses courses){
        Scanner sc = new Scanner(System.in);

        //1.输入cid
        System.out.println("请输入需要录入成绩的课程id：");
        String cid = sc.nextLine();

        //2.根据cid查找
        ElectiveCourse electiveCourse = scores.searchElect(cid);
        if (electiveCourse == null) {
            Course course = scores.courses.search(cid);
            if (course == null) {
                insertCour(courses);
                scores.initCourses(courses);
                course = scores.courses.search(cid);
            }
            electiveCourse = new ElectiveCourse(scores.students, course);
        }

        //3.输入sid录入成绩
        System.out.println("开始录入成绩，请输入学号：");
        String sid = sc.nextLine();
        System.out.println("请输入该学生的成绩：");
        int score = sc.nextInt();
        sc.nextLine();
        System.out.println("正在录入！");
        if (electiveCourse.addScore(sid, score)) {
            scores.addElective(electiveCourse);
            System.out.println("录入成绩成功！");
        } else {
            System.out.println("录入失败！");
        }
    }

    public static void CourseFind(Scores scores){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入课程编号：");
        String cid  = sc.nextLine();
        for (ElectiveCourse x : scores.electiveCourses) {
            if (x.course.getCid().equals(cid)) {
                System.out.println(x);
            }
        }
    }
    public static void func5(){
        //5功能未实现
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Courses courses = new Courses();
        Students students = new Students();
        Scores scores = new Scores(students, courses);
        Menu m = new Menu();
        int n = 0;
        do {
            m.menu1();
            System.out.print("请输入功能序号->");
            n = sc.nextInt();
            switch (n) {
                case 1 :
                    stuadmin(students);
                    break;
                case 2:
                    courseadmin(courses);
                    break;
                case 3:
                    CourseScoreInput(scores, courses);
                    break;
                case 4:
                    CourseFind(scores);
                    break;
                case 5:
                    //没有实现
                    break;
                case -1:
                    System.out.println("退出系统成功!");
                    break;
                default:
                    System.out.println("输入不合法，请重新输入！");
                    break;
            }
        } while (n != -1);
    }
}
