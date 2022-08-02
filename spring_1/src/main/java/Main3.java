import com.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {
    public static void main(String[] args) {
        //1.得到上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    }
}
