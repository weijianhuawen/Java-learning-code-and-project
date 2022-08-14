import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main6 {
    public static void main(String[] args) {
        //尝试获取枚举对象
        Class<?> c = Color.class;
        try {
            //获取构造方法对象
            Constructor<?> constructor = c.getDeclaredConstructor(String.class, int.class, String.class, int.class, int.class);
            //开权限
            constructor.setAccessible(true);
            //通过构造方法构造对象
            Color color = (Color) constructor.newInstance("蓝色", 88, 2);
            System.out.println(color);
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
