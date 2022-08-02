import com.beans.UserController3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main8 {
    public static void main(String[] args) {
        //获取UserController3的对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        UserController3 controller3 = (UserController3) context.getBean("userController3");
        controller3.sayHi();
    }
}
