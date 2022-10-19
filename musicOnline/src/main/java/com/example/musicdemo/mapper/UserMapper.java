package com.example.musicdemo.mapper;

import com.example.musicdemo.model.UserLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public UserLogin login(UserLogin user);

    //通过姓名进行查询
    public UserLogin getUserByName(String username);
}
