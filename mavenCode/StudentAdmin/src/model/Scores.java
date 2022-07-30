package model;

import java.util.ArrayList;
import java.util.List;

public class Scores {
    //课程库
    public Courses courses;
    //学生库
    public Students students;
    //记录单个学生的多门科目成绩
    public List<StudentCourse> studentCourses;
    //记录一个科目的成绩情况
    public List<ElectiveCourse> electiveCourses;


    public Scores(Students students, Courses courses) {
        studentCourses = new ArrayList<>();
        electiveCourses = new ArrayList<>();
        initCourses(courses);
        initStudents(students);
    }

    //初始化课程库，学生库
    public void initCourses(Courses courses) {
        this.courses = courses;
        for (StudentCourse x : studentCourses) {
            x.courses = courses;
        }
    }

    public void initStudents(Students students) {
        this.students = students;
        for (ElectiveCourse x : electiveCourses) {
            x.students = students;
        }
    }

    public void addStuCourses(StudentCourse s) {
        studentCourses.add(s);
    }

    public void addElective(ElectiveCourse e) {
        electiveCourses.add(e);
    }

    public ElectiveCourse searchElect(String cid) {
        for (ElectiveCourse x : electiveCourses) {
            System.out.println(x.course);
            if (x.course.getCid().equals(cid)) {
                return x;
            }
        }
        return null;
    }

    public void removeStuCourses(String sid) {
        studentCourses.removeIf(x -> x.student.getSid().equals(sid));
    }

    public void removeElectCourses(String cid) {
        electiveCourses.removeIf(x -> x.course.getCid().equals(cid));
    }
}
