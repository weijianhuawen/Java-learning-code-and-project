import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postParameter")
public class GetPostParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post请求body请求中的参数
        //设置请求与响应编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf8");
        //比如useId =   classId=
        String userId = req.getParameter("userId");
        String classId = req.getParameter("classId");
        //写会数据
        resp.getWriter().write("userId=" + userId + ", " + "classId=" + classId);
    }
}
