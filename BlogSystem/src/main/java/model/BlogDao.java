package model;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    //1.往博客列表里面插入博客

    public void insertBlog(Blog blog) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 1.连接数据库
            connection = DBUtil.getConnect();

            //2.构造sql语句
            String sql = "insert into blog values (null, ?, ?, ?, now())";
            statement = connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());

            //3.执行sql语句
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //4.释放资源
            DBUtil.close(null, statement, connection);
        }
    }
    //2.获取博客列表中的所有博客信息
    public List<Blog> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Blog> blogs = new ArrayList<>();
        try {
            // 1.建立连接
            connection = DBUtil.getConnect();

            //2.构造sql
            String sql = "select * from blog order by postTime desc";
            statement = connection.prepareStatement(sql);

            //3.执行sql
            resultSet = statement.executeQuery();

            //4.遍历结果集
            while (resultSet.next()) {
                Blog blog = new Blog();
                String content = resultSet.getString("content");
                //博客正文太长了，我们摘取前128个字符
                if (content.length() > 128) {
                    content = content.substring(0, 128) + "...";
                }
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(content);
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //5.释放资源
            DBUtil.close(resultSet, statement, connection);
        }
        return blogs;
    }
    //3.根据博客ID获取到具体的博客信息，即获取博客详情页
    public Blog getBlogDetail(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //1.连接数据库
            connection = DBUtil.getConnect();

            //2.构造sql
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            //3.执行sql
            resultSet = statement.executeQuery();

            //4.遍历结果集
            //由于我们的userId是主键约束的，它是唯一的，所以查询到的结果要么是一条要么是0条,所以获取一次就行
            if (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                return blog;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //5.释放资源
            DBUtil.close(resultSet, statement, connection);
        }
        return null;
    }

    //4.从博客表中删除博客
    public void deleteBlog(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //1.建立连接
            connection = DBUtil.getConnect();

            //2.构造sql
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);

            //3.执行sql
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //4.释放资源
            DBUtil.close(null, statement, connection);
        }
    }
}
