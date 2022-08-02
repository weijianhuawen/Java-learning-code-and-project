import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        //获取用户账号
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //验证账户
        //验证按照正常流程应该从数据库读数据，但是为了便于演示登录的逻辑，我们直接将账号密码写死
        //假设正确的账号与密码是 zhangsan 123
        if ("zhangsan".equals(username) && "123".equals(password)) {
            //登录成功
            //创建会话，为后续需登录的页面做准备
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("username", username);
            //初始情况下设置登录次数
            httpSession.setAttribute("count", 0);
            //跳转到目标页面index
            resp.sendRedirect("index");
        } else {
            //登录失败
            resp.getWriter().write("登录失败！");
        }
    }
}
