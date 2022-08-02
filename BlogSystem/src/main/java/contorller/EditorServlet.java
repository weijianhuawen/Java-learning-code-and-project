package contorller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/editor")
public class EditorServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式
        req.setCharacterEncoding("utf8");
        resp.setContentType("application/json; charset=utf8");
        //获取会话，查看用户登录状态
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            //session不存在或内部的没有user信息表示用户未登录
            String jsonStr = "{\"ok\":false, \"reason\":\"当前未登录!无法编写博客!请登录!\"}";
            resp.getWriter().write(jsonStr);
            return;
        }
        //获取博客标题与内容以及用户id构造博客对象
        BlogDao blogDao = new BlogDao();
        Blog blog = objectMapper.readValue(req.getInputStream(), Blog.class);
        User user = (User) session.getAttribute("user");
        if (blog.getTitle() == null ||
                blog.getContent() == null ||
                "".equals(blog.getTitle()) ||
                "".equals(blog.getTitle())) {
            String jsonStr = "{\"ok\":false, \"reason\":\"标题或者文章为空!\"}";
            resp.getWriter().write(jsonStr);
            return;
        }
        blog.setUserId(user.getUserId());
        //储存博客
        blogDao.insertBlog(blog);
        //返回响应
        String jsonStr =  "{\"ok\":true, \"reason\":\"博客发布成功!\"}";
        resp.getWriter().write(jsonStr);
    }
}
