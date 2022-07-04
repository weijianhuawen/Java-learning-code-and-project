import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJdbcSelect {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        //关联数据源
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
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //执行sql 查询操作返回的不是int 而是一个临时表 使用ResultSet对象表示这个临时表
        ResultSet ret = statement.executeQuery();

        //便利结果集合
        //预期结果格式
//        +------+--------+
//        | id   | name   |
//        +------+--------+
//        |    1 | 王五   |
//        +------+--------+
        while (ret.next()) {
            int id = ret.getInt("id");
            String name = ret.getString("name");
            System.out.println("id:" + id + ", name:" + name);
        }
        //关闭资源
        ret.close();
        statement.close();
        connection.close();
    }
}
