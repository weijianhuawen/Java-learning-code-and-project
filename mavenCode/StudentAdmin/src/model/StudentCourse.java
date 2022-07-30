package model;

import java.util.HashMap;
import java.util.Map;

public class StudentCourse {
    //课程库
    public Courses courses;
    //学生
    public Student student;
    //该学生课程对应的成绩
    public Map<Course, Integer>  scoreContainer;

    public StudentCourse(Courses courses, Student student) {
        this.courses = courses;
        scoreContainer = new HashMap<>();
        this.student = student;
    }
    //录入/更新成绩
    public boolean addScore(String cid, int score) {
        Course course = courses.search(cid);
        if (cid == null) return false;
        scoreContainer.put(course, score);
        return true;
    }

    //更新课程库
    public void update(Courses courses) {
        this.courses = courses;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(student.name);
        stringBuilder.append(":[ ");
        for(Map.Entry<Course, Integer> entry : scoreContainer.entrySet()) {
            stringBuilder.append("课程名称：");
            stringBuilder.append(entry.getKey().courseName);
            stringBuilder.append("课程分数：");
            stringBuilder.append(entry.getValue());
            stringBuilder.append(" ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
