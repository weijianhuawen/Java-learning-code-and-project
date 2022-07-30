import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class User {
    public String userId;
    public String classId;
}
@WebServlet("/getJsonPost")
public class GetJsonPostServlet extends HttpServlet {
    //1.创建一个Jackson的核心对象
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //格式
        resp.setContentType("text/html; charset=utf8");
        //处理
        //2.读取body请求的内容，使用ObjectMapper对象的readValue方法来解析
        //就是将字符串转换成java的对象，readValue方法的第一个参数可以是路径字符串可以是输入流对象，引入可以是File对象
        //第二个参数，表示需要将请求的json格式数据转换成哪一个java对象
        User user = objectMapper.readValue(req.getInputStream(), User.class);
        System.out.println(user.userId);
        System.out.println(user.classId);
        resp.getWriter().write("userId=" + user.userId + "  ,classId=" + user.classId);
    }
}
