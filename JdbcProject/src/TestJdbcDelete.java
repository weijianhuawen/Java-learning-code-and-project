import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJdbcDelete {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        Scanner sc = new Scanner(System.in);
        //关联数据源
        //设置数据库所在地址
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/jdbctest?characterEncoding=utf8&useSSL=false");
        //设置登录数据库的账户名
        ((MysqlDataSource)dataSource).setUser("root");
        //设置登录数据库的密码
        ((MysqlDataSource)dataSource).setPassword("123456");

        //建立连接
        Connection connection = dataSource.getConnection();

        //用户输入
        System.out.println("请输入需要删除的学号：");
        int id = sc.nextInt();

        //操作数据库 关键在于构造sql语句
        //jdbc 构造的sql语句不需要带上;
        String sql = "delete from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        System.out.println("statement" + statement);

        //执行sql
        int ret = statement.executeUpdate();
        System.out.println(ret);

        //关闭资源
        statement.close();
        connection.close();
    }
}
