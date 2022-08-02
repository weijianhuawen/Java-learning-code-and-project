import com.beans.UserController1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main6 {
    public static void main(String[] args) {
        //获取UserController1的对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        UserController1 controller1 = (UserController1) context.getBean("userController1");
        controller1.sayHi();
    }
}
