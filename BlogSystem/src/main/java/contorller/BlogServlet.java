package contorller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    //解析json
    private final ObjectMapper objectMapper = new ObjectMapper();

    //获取博客列表页或者获取博客的详情页
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        //用于查询数据库获取博客
        BlogDao blogDao = new BlogDao();
        //获取请求的blogid 如果存在就是查询一篇博客的详情页 不存在就是获取博客的列表页
        String param = req.getParameter("blogId");
        System.out.println(param);
        if (param == null) {
            //获取博客  列表
            List<Blog> blogs = blogDao.selectAll();
            String jsonStr = objectMapper.writeValueAsString(blogs);
            resp.getWriter().write(jsonStr);
        } else {
            //获取博客  详情页
            int blogId = Integer.parseInt(param);
            Blog blog = blogDao.getBlogDetail(blogId);
            String jsonStr = objectMapper.writeValueAsString(blog);
            resp.getWriter().write(jsonStr);
        }

    }
}
