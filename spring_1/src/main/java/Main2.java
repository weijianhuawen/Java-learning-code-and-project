import com.bean.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main2 {
    public static void main(String[] args) {
        //1.得到Bean工厂
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring.xml"));

        //2.获取Bean
        User user = (User) factory.getBean("user");

        //3.使用
        user.sayHi("李四");
    }
}
