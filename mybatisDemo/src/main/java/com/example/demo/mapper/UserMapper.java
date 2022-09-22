package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据id查询
    public UserInfo getUserById(@Param(value = "id") Integer id);
    //根据唯一名字进行查询
    public UserInfo getUserByFullName(@Param(value = "username") String username);
    //对数据进行排序并返回结果列表
    public List<UserInfo> getOrderList(@Param(value = "order") String order);
    //根据id修改名字
    public Integer updateName(@Param(value = "id") Integer id, @Param(value = "username") String username);
    //根据id删除用户
    public Integer delById(@Param(value = "id") Integer id);
    //添加用户，返回影响行数
    public Integer add(UserInfo userInfo);
    //动态sql添加用户，其中photo非必传
    public Integer add2(UserInfo userInfo);

    public Integer addGetId(UserInfo userInfo);

    //登录,并返回用户信息
    public UserInfo login(@Param("username") String username, @Param(("password")) String password);

    //模糊查询
    public List<UserInfo> getListByName(@Param("username") String username);

    //根据用户id查询用户以及文章列表
    public UserInfo getUserAndArticlesById(@Param("uid") Integer uid);

    //使用动态sql插入数据
    public int addUser(UserInfo userInfo);
    //使用动态sql插入数据
    public int addUser2(UserInfo userInfo);

    //使用动态SQL实现修改用户信息，包括账户名，密码，头像
    public int updateUser(UserInfo userInfo);

    //使用动态sql批量删除元素
    public int deleteIds(List<Integer> ids);
}
