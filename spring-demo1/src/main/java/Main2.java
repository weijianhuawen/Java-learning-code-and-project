import com.beans.APIController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        APIController api = (APIController) context.getBean("APIController", APIController.class);
        api.sayHi();
    }
}
