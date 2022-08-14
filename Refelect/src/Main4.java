import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main4 {
    public static void main(String[] args) {
        try {
            //1.获取Class对象
            Class<?> c = Class.forName("Student");
            //2.获取Student的一个实例对象
            Student student = (Student) c.newInstance();
            //3.通过class对象获取实例的方法对象，参数为方法名，以及形参列表
            Method method =  c.getDeclaredMethod("function", String.class);
            //4.为私有方法开访问权限
            method.setAccessible(true);
            //5.通过invork方法调用方法
            method.invoke(student, "私有方法参数");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
