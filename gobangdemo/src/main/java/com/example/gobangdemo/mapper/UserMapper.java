package com.example.gobangdemo.mapper;

import com.example.gobangdemo.mode.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 注册
    void add(User user);
    // 登录
    User userSelectByName(String username);
}
