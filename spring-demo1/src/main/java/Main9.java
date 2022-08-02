import com.beans.UserController4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main9 {
    public static void main(String[] args) {
        //获取UserController4的对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        UserController4 controller4 = (UserController4) context.getBean("userController4");
        controller4.sayHi();
    }
}
