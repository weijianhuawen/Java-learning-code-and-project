import com.beans.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserController userController = context.getBean("userController", UserController.class);

        userController.sayHi("张三");
    }
}
