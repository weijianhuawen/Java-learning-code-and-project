public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取class对象的方式

        //方式1：通过forName方法
        //Class类中的forName方法，所需参数为含包名的类全名，类型为String，返回值是Class<?>
        Class<?> c1 = Class.forName("Student");
        //方式2：通过类名.class获取
        Class<?> c2 = Student.class;
        //方式3：使用实例对象调用getclass方法获取
        Student s = new Student();
        Class<?> c3 = s.getClass();

        //我们来看一看通过三种方式获取到的对象是不是同一个对象
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2 == c3);
    }
}
