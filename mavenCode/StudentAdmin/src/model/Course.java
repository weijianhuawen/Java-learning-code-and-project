package model;

public class Course {
    //id
    private final String cid;
    //课程名称
    public String courseName;
    //课程性质
    public String courseNature;

    //课程类别
    public String courseClass;
    //学分
    public int credit;
    //开设学期
    public String semester;

    public Course(String id) {
        this.cid = id;
    }
    public Course(String id, String name, String nature, String category, int credit, String semester) {
        this.cid = id;
        this.courseName = name;
        this.courseNature = nature;
        this.courseClass = category;
        this.credit = credit;
        this.semester = semester;
    }

    public String getCid() {
        return cid;
    }

    @Override
    public String toString() {
        return "model.Course{" +
                "cid='" + cid + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseNature='" + courseNature + '\'' +
                ", courseClass='" + courseClass + '\'' +
                ", credit=" + credit +
                ", semester='" + semester + '\'' +
                '}';
    }
}
