import com.beans.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main4 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        User userinfo = context.getBean("userinfo", User.class);
        System.out.println(userinfo);
        System.out.println("-------------------------------");
        User userdemo = context.getBean("userdemo", User.class);
        System.out.println(userdemo);
        System.out.println("-------------------------------");
    }
}
