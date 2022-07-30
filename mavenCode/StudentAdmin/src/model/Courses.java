package model;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    //课程
    public List<Course> courses;

    public Courses() {
        courses = new ArrayList<>();
    }

    public boolean add(Course course) {
        if (courses.contains(course) || course.getCid() == null || course.courseName == null) {
            return false;
        }
        courses.add(course);
        return true;
    }
    public Course search(String id) {
        Course course = null;
        for (Course x : courses) {
            if (x.getCid().equals(id)) {
                course = x;
                break;
            }
        }
        return course;
    }
    public Course remove(String id) {
        Course course = search(id);
        if (course == null) {
            return null;
        }
        courses.remove(course);
        return course;
    }
    public boolean setName(String id, String name) {
        Course course = search(id);
        if (course == null) {
            return false;
        }
        course.courseName = name;
        return true;
    }
    public boolean setNature(String id, String nature) {
        Course course = search(id);
        if (course == null) {
            return false;
        }
        course.courseNature = nature;
        return true;
    }
    public boolean setClass(String id, String courseClass) {
        Course course = search(id);
        if (course == null) {
            return false;
        }
        course.courseClass = courseClass;
        return true;
    }
    public boolean setCredit(String id, int credit) {
        Course course = search(id);
        if (course == null) {
            return false;
        }
        course.credit = credit;
        return true;
    }
    public boolean setSemester(String id, String semester) {
        Course course = search(id);
        if (course == null) {
            return false;
        }
        course.semester = semester;
        return true;
    }
    public boolean setAll(String id, String name, String nature, String courseClass, int credit, String semester) {
        Course course = search(id);
        if (course == null) {
            return false;
        }
        course.courseName = name;
        course.courseNature = nature;
        course.courseClass = courseClass;
        course.credit = credit;
        course.semester = semester;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("课程id：{ ");
        for (Course x : courses) {
            stringBuilder.append(x.getCid());
            stringBuilder.append("  ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
