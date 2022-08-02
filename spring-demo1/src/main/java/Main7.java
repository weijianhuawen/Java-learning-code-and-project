import com.beans.UserController2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main7 {
    public static void main(String[] args) {
        //获取UserController2的对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        UserController2 controller2 = (UserController2) context.getBean("userController2");
        controller2.sayHi();
    }
}
