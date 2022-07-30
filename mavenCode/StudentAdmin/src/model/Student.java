package model;

public class Student {
    //学号 唯一
    private final String sid;
    //姓名
    public String name;
    //性别
    public String sex;
    //入学年份
    public String join;
    //专业
    public String major;
    //班级
    public String c;

    public Student(String id, String name, String sex, String join, String major, String c){
        this.sid = id;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.join = join;
        this.c = c;
    }

    public String getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getJoin() {
        return join;
    }

    public String getMajor() {
        return major;
    }

    public String getC() {
        return c;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", join='" + join + '\'' +
                ", major='" + major + '\'' +
                ", class='" + c + '\'' +
                '}';
    }
}
