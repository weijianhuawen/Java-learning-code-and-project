import com.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //获取对象时使用小驼峰形式的类名作为name参数
        UserService service = (UserService) context.getBean("userService", UserService.class);
        service.sayHi();
        UserConfiguration configuration = (UserConfiguration) context.getBean("userConfiguration");
        configuration.sayHi();
        UserComponent component = (UserComponent) context.getBean("userComponent");
        component.sayHi();
        UserRepository repository = (UserRepository) context.getBean("userRepository");
        repository.sayHi();
    }
}
