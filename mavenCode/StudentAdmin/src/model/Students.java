package model;
import java.util.List;
public class Students {
    public static class StudentNode {
        public Student val;
        public StudentNode next;
        public StudentNode prev;
        public StudentNode() {

        }
        public StudentNode(Student val) {
            this.val = val;
        }
    }
    //学生列表
    public StudentNode head;
    public StudentNode tail;
    //学生个数
    public int size;

    public Students() {
        size = 0;
    }
    public Students(Student[] students) {
        if (students == null || students.length == 0) return;
        size = students.length;
        head = new StudentNode(students[0]);
        tail = head;
        for (int i = 1; i  < size; i++) {
            tail.next = new StudentNode(students[i]);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }
    public Students(List<Student> students) {
        if (students == null || students.size() == 0) return;
        size = students.size();
        head = new StudentNode(students.get(0));
        tail = head;
        for (int i = 1; i  < size; i++) {
            tail.next = new StudentNode(students.get(i));
            tail.next.prev = tail;
            tail = tail.next;
        }
    }
    //添加学生
    public boolean add(Student student) {
        if (student.getSid() == null || student.getName() == null || student.getMajor() == null) {
            return false;
        }
        StudentNode node = new StudentNode(student);
        if (head == tail && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        size++;
        return true;
    }

    //删除学生
    public Student remove(String id) {
        StudentNode cur = head;
        if (head.val.getSid().equals(id)) {
            head = head.next;
            if (head == null) {
                tail = head;
            }
            return cur.val;
        }
        while (cur != null) {
            if (cur.val.getSid().equals(id)) {
                Student ret = cur.val;
                if (cur.next == null) {
                    tail = cur.prev;
                    tail.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return ret;
            }
            cur = cur.next;
        }
        return null;
    }
    //查询学生
    public Student search(String id) {
        StudentNode cur = head;
        while (cur != null) {
            if (cur.val.getSid().equals(id)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
    //修改学生信息
    public boolean setName(String id, String name){
        Student student = search(id);
        if (student == null) {
            return false;
        }
        student.name = name;
        return true;
    }
    public boolean setSex(String id, String sex){
        Student student = search(id);
        if (student == null) {
            return false;
        }
        student.sex = sex;
        return true;
    }
    public boolean setJoin(String id, String join){
        Student student = search(id);
        if (student == null) {
            return false;
        }
        student.join = join;
        return true;
    }

    public boolean setMajor(String id, String major){
        Student student = search(id);
        if (student == null) {
            return false;
        }
        student.major = major;
        return true;
    }
    public boolean setClass(String id, String c){
        Student student = search(id);
        if (student == null) {
            return false;
        }
        student.c = c;
        return true;
    }
    public boolean setAll(String id, String name, String sex, String join, String major, String c) {
        Student student = search(id);
        if (student == null) {
            return false;
        }
        student.name = name;
        student.sex = sex;
        student.join = join;
        student.major = major;
        student.c = c;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder( "model.Students{ ");
        StudentNode node = head;
        while (node != null) {
            stringBuilder.append(node.val.getSid());
            stringBuilder.append(" ");
            node = node.next;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
