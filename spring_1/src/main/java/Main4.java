import com.bean.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main4 {
    public static void main(String[] args) {
        //1.得到Bean工厂
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
    }
}
