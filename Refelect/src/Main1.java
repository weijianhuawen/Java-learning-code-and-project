public class Main1 {
    public static void main(String[] args) {
        //获取相关类的Class对象
        Class<?> c = Student.class;
        //使用newInstance方法获取实例
        try {
            Student student = (Student) c.newInstance();
            System.out.println(student);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
