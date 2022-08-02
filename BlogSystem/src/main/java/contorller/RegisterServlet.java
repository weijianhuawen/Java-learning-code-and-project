package contorller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Register;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        resp.setContentType("application/json; charset=utf8");
        //获取注册信息
        Register register = objectMapper.readValue(req.getInputStream(), Register.class);
        if (register == null) {
            //没有注册信息
            resp.getWriter().write("{\"ok\":\"none\"}");
            return;
        }
        //检验注册信息是否完整和正确
        String username = register.getUsername();
        String password = register.getPassword();
        String ispassword = register.getIspassword();
        if (username == null
                || password == null
                || ispassword == null
                || "".equals(username)
                || "".equals(password)
                || "".equals(ispassword)) {
            //信息不完整
            resp.getWriter().write("{\"ok\":\"lack\"}");
            return;
        }
        //查找数据库是否存在该用户名
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(username);
        if (user != null) {
            //用户名已经存在
            resp.getWriter().write("{\"ok\":\"repeat\"}");
            return;
        }
        //密码与确认密码是否相同
        if (!password.equals(ispassword)) {
            resp.getWriter().write("{\"ok\":\"no\"}");
            return;
        }
        //注册
        userDao.insertUser(register);
        resp.getWriter().write("{\"ok\":\"yes\"}");
    }
}
