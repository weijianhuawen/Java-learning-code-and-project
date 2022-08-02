package contorller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式
        resp.setContentType("application/json; charsetutf8");
        resp.setCharacterEncoding("utf8");
        //找到当前会话
        HttpSession session = req.getSession(false);
        //会话不存在，没有注销的必要
        if (session == null || session.getAttribute("user") == null) {
            String jsonStr = "{\"ok\":false, \"reason\":\"当前未登录!无需退出登录!\"}";
            resp.getWriter().write(jsonStr);
            return;
        }
        //会话存在删除会话
        session.removeAttribute("user");
        String jsonStr = "{\"ok\":true, \"reason\":\"退出登录成功!\"}";
        resp.getWriter().write(jsonStr);
    }


}
