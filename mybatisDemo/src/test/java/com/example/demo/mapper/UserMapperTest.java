package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.sampled.Line;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void gerUserById() {
        UserInfo userInfo = userMapper.getUserById(1);
        //System.out.println(userInfo);
        Assertions.assertNotNull(userInfo);
    }
    @Test
    @Transactional
    void updateName() {
        int result = userMapper.updateName(2, "王五");
        Assertions.assertSame(1,result);
    }
    @Test
    @Transactional
    void delById() {
        int result = userMapper.delById(1);
        Assertions.assertSame(1,result);
    }

    @Test
    @Transactional
    void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("老六");
        userInfo.setPassword("888");
        userInfo.setPhoto("default.png");
        int result = userMapper.add(userInfo);
        Assertions.assertSame(1,result);
    }

    @Test
    @Transactional
    void addGetId() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("老六");
        userInfo.setPassword("888");
        userInfo.setPhoto("default.png");
        System.out.println("插入之前的id=" + userInfo.getId());
        int result = userMapper.addGetId(userInfo);
        System.out.println("插入之后的id=" + userInfo.getId());
        Assertions.assertSame(1,result);

    }

    @Test
    void getUserByFullName() {
        UserInfo userInfo = userMapper.getUserByFullName("张三");
        System.out.println(userInfo);
    }

    @Test
    void getOrderList() {
        List<UserInfo> userMappers = userMapper.getOrderList("desc");
        System.out.println(userMappers);
    }
}