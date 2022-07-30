import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/autorefresh")
public class AutoRefreshServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式
        resp.setContentType("text/html; charset = utf8");
        //设置Refresh，第二个参数表示刷新频率，单位是秒
        resp.setHeader("Refresh", "1");
        //响应
        resp.getWriter().write("时间戳：" + System.currentTimeMillis());
    }
}
