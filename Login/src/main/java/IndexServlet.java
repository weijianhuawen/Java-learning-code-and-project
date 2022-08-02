import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //返回一个主页
        //获取会话,参数必须是false
        HttpSession httpSession = req.getSession(false);
        //取出会话信息
        String username = (String) httpSession.getAttribute("username");
        Integer cnt = (Integer) httpSession.getAttribute("count");
        //访问次数加1
        cnt++;
        //写回到会话中
        httpSession.setAttribute("count", cnt);

        //构造页面。我们简单构造一下就好
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("<h3>欢迎您!" + username + "</h3> <h4>这个主页已经被访问了" + cnt + "次</h4>");
    }
}
