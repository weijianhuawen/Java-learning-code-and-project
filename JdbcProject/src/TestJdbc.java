import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJdbc {

    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号：");
        int id = sc.nextInt();
        System.out.println("请输入姓名：");
        sc.nextLine();
        String name = sc.nextLine();
        //设置数据库所在地址
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jdbctest?characterEncoding=utf8&useSSL=false");
        //设置登录数据库的账户名
        ((MysqlDataSource)dataSource).setUser("root");
        //设置登录数据库的密码
        ((MysqlDataSource)dataSource).setPassword("123456");

        //建立连接
        Connection connection = dataSource.getConnection();

        //操作数据库 关键在于构造sql语句
        //jdbc 构造的sql语句不需要带上;
        String sql = "insert into student values(?, ?)";
        //将sql字符串包装成一个语句对象，表示待执行的sql的对象
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        System.out.println("statement" + statement);

        //执行sql
        //如果待执行的sql语句操作是insert, update, delete,则使用executeUpdate方法执行,返回值为影响数据的行数
        //如果待执行的sql语句操作是select,则使用executeQuery方法执行
        int ret = statement.executeUpdate();
        System.out.println(ret);

        //此时sql语句已经执行完毕了，需要释放资源
        statement.close();
        connection.close();
    }
}
