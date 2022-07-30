import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//将响应的请求使用注解与http 带有"/hello"的URL关联起来
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //不要调用父类的构造方法
        //super.doGet(req, resp);

        //控制台输出hello world
        System.out.println("hello world");
        //放入响应的body中，页面就能显示hello world了
        resp.getWriter().write("hello world" + System.currentTimeMillis());
    }
}
