import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/showreq")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        resp.setContentType("text/html; charset=utf-8");
        //1协议名称与版本
        stringBuilder.append("协议版本:");
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("<br>");
        //2方法类型
        stringBuilder.append("方法:");
        stringBuilder.append(req.getMethod());
        stringBuilder.append("<br>");
        //3获取查URL路径
        stringBuilder.append("URL路径:");
        stringBuilder.append(req.getRequestURI());
        stringBuilder.append("<br>");
        //4URL（不包括查询字符串后面的部分）
        stringBuilder.append("URL（不包括查询字符串后面的部分）:");
        stringBuilder.append(req.getRequestURL());
        stringBuilder.append("<br>");

        //5一级路径
        stringBuilder.append("一级路径:");
        stringBuilder.append(req.getContextPath());
        stringBuilder.append("<br>");
        //6查询字符串
        stringBuilder.append("查询字符串:");
        stringBuilder.append(req.getQueryString());
        stringBuilder.append("<br>");
        //7正文编码格式
        stringBuilder.append("正文编码格式:");
        stringBuilder.append(req.getCharacterEncoding());
        stringBuilder.append("<br>");
        //8mine
        stringBuilder.append("mine:");
        stringBuilder.append(req.getContentType());
        stringBuilder.append("<br>");
        //9正文长度
        stringBuilder.append("正文长度:");
        stringBuilder.append(req.getContentLength());
        stringBuilder.append("<br>");
        //10获得每一个查询字符串的键值：
        stringBuilder.append("<h3>获得每一个查询字符串的键值：</h3>");
        Enumeration query = req.getParameterNames();
        while(query.hasMoreElements()) {
            String key = (String)query.nextElement();
            stringBuilder.append(key);
            stringBuilder.append(":");
            stringBuilder.append(req.getParameter(key));
            stringBuilder.append("<br>");
        }
        //11获得头部的键值
        stringBuilder.append("<h3>获得头部的键值：</h3>");
        Enumeration header = req.getHeaderNames();
        while(header.hasMoreElements()) {
            String key = (String)header.nextElement();
            stringBuilder.append(key);
            stringBuilder.append(":");
            stringBuilder.append(req.getHeader(key));
            stringBuilder.append("<br>");
        }
        resp.getWriter().write(stringBuilder.toString());
    }
}
