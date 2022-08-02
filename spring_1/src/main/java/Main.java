import com.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //1.得到上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //2.获取bean对象
//        User user = (User) context.getBean("user");
//        User user = (User) context.getBean(User.class);
        User user = context.getBean("user", User.class);

        //3.使用bean
        user.sayHi("张三");
    }
}
