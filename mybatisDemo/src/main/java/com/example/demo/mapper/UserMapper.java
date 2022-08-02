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
    //
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
}
