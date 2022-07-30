import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式
        resp.setContentType("text/html; charset=utf8");
        //设置状态码
        int status = 404;
        resp.setStatus(status);

        resp.getWriter().write("hello,这是" + status + "状态码的响应内容!");
    }
}
