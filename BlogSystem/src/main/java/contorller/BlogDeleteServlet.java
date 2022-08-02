package contorller;

import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/blogDelete")
public class BlogDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式
        req.setCharacterEncoding("utf8");
        resp.setContentType("application/json; charset=utf8");
        //获取会话，检查是否登录
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            String jsonStr = "{\"ok\":false, \"reason\":\"当前未登录!请先登录!\"}";
            resp.getWriter().write(jsonStr);
            return;
        }

        //获取文章id
        String parma = req.getParameter("blogId");
        if (parma == null || "".equals(parma)) {
            String jsonStr = "{\"ok\":false, \"reason\":\"参数缺失!删除失败!\"}";
            resp.getWriter().write(jsonStr);
            return;
        }
        int blogId = Integer.parseInt(parma);
        //获取User
        User user = (User) session.getAttribute("user");
        //验证
        BlogDao blogDao = new BlogDao();
        Blog select = blogDao.getBlogDetail(user.getUserId());
        if (select == null) {
            //验证失败，访问用户与作者信息不同，没有删除权限或者该文章不存在或已经删除

            String jsonStr = "{\"ok\":false, \"reason\":\"博客已经被删除或不存在!\"}";
            resp.getWriter().write(jsonStr);
            return;
        }
        if (select.getBlogId() != user.getUserId()) {
            //不是作者
            String jsonStr = "{\"ok\":false, \"reason\":\"你不是作者，无权删除!\"}";
            resp.getWriter().write(jsonStr);
            return;
        }
        //确认无误，准备删除
        blogDao.deleteBlog(blogId);
        String jsonStr =  "{\"ok\":true, \"reason\":\"博客删除成功!\"}";
        resp.getWriter().write(jsonStr);
     }
}
