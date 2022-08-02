package contorller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Account;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置格式防止乱码
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        //获取账号与密码
        Account account = objectMapper.readValue(req.getInputStream(), Account.class);
        //验证
        String username = account.getUsername();
        String password = account.getPassword();
        System.out.println(username);
        System.out.println(password);
        resp.setContentType("application/json; charset=utf8");
        if (username == null || password == null || "".equals(username) || "".equals(password)) {
            //缺少密码或账号,构造json字符串返回响应状态
            resp.getWriter().write("{\"ok\":\"lack\"}");
            return;
        }
        //数据库查询用户信息
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(username);
        System.out.println(user);
        if (user != null && username.equals(user.getUserName()) && password.equals(user.getPassword())) {
            //登录成功，准备创建会话
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("user", user);
            //重定向到博客列表页
            //resp.sendRedirect("blog_list.html");
            //告诉前端验证成功，可以重定向到主页
            resp.getWriter().write("{\"ok\":\"yes\"}");
        } else {
            //登录失败，账号或密码错误
            resp.getWriter().write("{\"ok\":\"no\"}");
        }
    }

    //检测登录状态，对未登录的用户进行拦截
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        //获取会话
        HttpSession httpSession = req.getSession(false);
        User result = new User();
        if (httpSession == null) {
            //会话不存在，表示用户未登录
            result.setUserId(-1);
            result.setUserName("");
            String jsonStr = objectMapper.writeValueAsString(result);
            resp.getWriter().write(jsonStr);
            return;
        }
        //查询用户在会话信息是否存在
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            //会话中不存在
            result.setUserId(-1);
            result.setUserName("");
            String jsonStr = objectMapper.writeValueAsString(result);
            resp.getWriter().write(jsonStr);
            return;
        }
        //表示已经登录，验证通过
        //清除密码
        user.setPassword("");
        String jsonStr = objectMapper.writeValueAsString(user);
        System.out.println(jsonStr);
        resp.getWriter().write(jsonStr);
    }
}
