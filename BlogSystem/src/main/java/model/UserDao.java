package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //1.根据用户，名查找用户信息，登录也需要使用到
    public User selectByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //建立连接
            connection = DBUtil.getConnect();

            //构造sql
            String sql = "select * from user where username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            //执行sql
            resultSet = statement.executeQuery();

            //用户名唯一，遍历一次就好
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            DBUtil.close(resultSet, statement, connection);
        }
        return null;
    }
    //2.根据用户id获取用户详细信息
    public User selectByUserId(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //建立连接
            connection = DBUtil.getConnect();

            //构造sql
            String sql = "select * from user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            //执行sql
            resultSet = statement.executeQuery();

            //用户名唯一，遍历一次就好
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            DBUtil.close(resultSet, statement, connection);
        }
        return null;
    }
    //3.插入新用户信息，注册
    public void insertUser(Register register) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //建立连接
            connection = DBUtil.getConnect();

            //构造sql
            String sql = "insert into user values(null, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, register.getUsername());
            statement.setString(2, register.getPassword());

            //执行sql
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            DBUtil.close(null, statement, connection);
        }
    }
}
