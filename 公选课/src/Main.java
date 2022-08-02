public class Main {
    public static void main(String[] args) {
        int a;
        Student stu1 = new Student(1);
        Student stu2 = new Student(2);
        System.out.println(stu1.getId() + "   " + stu2.getId());
    }
}
class Student {
    private static int nextInt = 1;
    private int id;
    public Student (int stuId) {
        id = stuId;
    }

    public int getId() {
        return id;
    }
}