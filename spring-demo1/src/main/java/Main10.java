import com.beans.UserController5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main10 {
    public static void main(String[] args) {
        //获取UserController5的对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        UserController5 controller5 = (UserController5) context.getBean("userController5");
        controller5.sayHi();
    }
}

