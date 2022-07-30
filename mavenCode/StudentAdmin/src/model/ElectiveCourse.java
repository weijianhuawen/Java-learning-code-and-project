package model;

import java.util.*;

/**
 * 课程选修情况类
 */

public class ElectiveCourse {
    //课程
    public Course course;
    //选修学生成绩信息
    public Map<Student, Integer> courseScores;
    //学生库
    public Students students;
    public ElectiveCourse(Students students, Course course){
        this.course = course;
        this.students = students;
        courseScores = new HashMap<>();
    }

    //根据学号录入成绩，修改学生成绩
    public boolean addScore(String sid, int score) {
        Student student = students.search(sid);
        if (student == null) return false;
        courseScores.put(student, score);
        return true;
    }
    //更新学生库
    public void update(Students students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(course.courseName);
        stringBuilder.append(":[ ");
        for(Map.Entry<Student, Integer> entry : courseScores.entrySet()) {
            stringBuilder.append("姓名：");
            stringBuilder.append(entry.getKey().name);
            stringBuilder.append("分数：");
            stringBuilder.append(entry.getValue());
            stringBuilder.append(" ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
