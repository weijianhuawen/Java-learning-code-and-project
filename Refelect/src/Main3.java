import java.lang.reflect.Field;

public class Main3 {
    public static void main(String[] args) {
        //1.获取Class对象
        Class<?> c = Student.class;
        try {
            //2.通过Class对象获取对应类的实例对象
            Student student = (Student) c.newInstance();
            //获取私有属性name
            Field field =  c.getDeclaredField("name");
            //给该私有属性开权限
            field.setAccessible(true);
            //3.修改该私有属性
            field.set(student, "被反射修改的私有属性");
            System.out.println(student);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
