import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.获取Clas对象
        Class<?> c = Class.forName("Student");
        //2.获取指定参数列表的构造器，我们演示获取Student中的一个私有构造器,参数传形参列表类型
        try {
            Constructor<?> constructor = c.getDeclaredConstructor(String.class, int.class);
            //获取的私有构造方法，需要打开访问权限,默认关闭
            constructor.setAccessible(true);
            //3.根据获取到的构造器获取实例对象,使用newInstance方法记得传入构造器需要的参数
            Student student = (Student) constructor.newInstance("李四", 20);
            System.out.println(student);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
