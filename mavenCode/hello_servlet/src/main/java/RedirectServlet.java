import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式
        resp.setContentType("text/html; charset = utf8");
        //设置状态码
//        resp.setStatus(302);
//        //设置重定向字段与地址,如跳转到力扣官网
//        resp.setHeader("Location", "https://leetcode.cn/");
        resp.sendRedirect("https://leetcode.cn/");
    }
}
