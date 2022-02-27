import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Test {
    public static void main(String[] args) {
        SimpleEmail email = new SimpleEmail();
        //qq：qq邮件服务器的端口号
        email.setSslSmtpPort("994");
        //
        email.setHostName("smtp.163.com");
        //
        email.setAuthentication("weijianhuawen@163.com", "NBTTBOJTTLHUZVLC");
        email.setCharset("UTF-8");
        //1、从文件把所有的qq邮箱读取出来
        //2、存储到一个数据结构当中
        //3、String email = 数据结构当中取一个
        try {
            email.addTo("2425675841@qq.com");
            //email.addTo("1262913815@qq.com");
            email.setFrom("weijianhuawen@163.com");
            email.setSubject("只为中原杂碎");
            email.setMsg("曾经一思泪断肠，无语处，问何望。千寻烟波，相逢最渺茫。芦管晓吹夜不禁，月空照，孤影长。年来得此苦与伤，欲相弃，心如霜。相思难尽，日日萦我窗。天共水色飘雾时，朝霞在，梦中央。");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
