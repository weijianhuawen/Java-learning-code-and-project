package contorller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/authorInfo")
public class AuthorServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式
        resp.setContentType("application/json; charset=utf8");
        req.setCharacterEncoding("utf8");
        //获取查询字符串上面的博客id
        String parma = req.getParameter("blogId");
        if (parma == null || "".equals(parma)) {
            //博客id非法
            String jsonStr = "{\"ok\":false, \"reason\":\"请求参数不完整!\"}";
            resp.getWriter().write(jsonStr);
            return;
        }
        //获取博客信息
        BlogDao blogDao = new BlogDao();
        int blogId = Integer.parseInt(parma);
        Blog blog = blogDao.getBlogDetail(blogId);
        if (blog == null) {
            //没有找到对应博客
            String jsonStr = "{\"ok\":false, \"reason\":\"没有查询到对应的博客信息!\"}";
            resp.getWriter().write(jsonStr);
            return;
        }
        //根据博客信息找到User
        UserDao userDao = new UserDao();
        int userId = blog.getUserId();
        User user = userDao.selectByUserId(userId);
        if (user == null) {
            //没有该作者
            String jsonStr = "{\"ok\":false, \"reason\":\"没有查询到对应的作者信息\"!}";
            resp.getWriter().write(jsonStr);
            return;
        }
        //最终找到了
        user.setPassword("");
        String jsonStr = objectMapper.writeValueAsString(user);
        resp.getWriter().write(jsonStr);
    }
}
