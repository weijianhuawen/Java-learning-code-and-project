package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void gerUserById() {
        UserInfo userInfo = userMapper.getUserById(null);
        System.out.println(userInfo);
        //Assertions.assertNotNull(userInfo);
    }
    @Test
    @Transactional
    void updateName() {
        int result = userMapper.updateName(2, "李四");
        Assertions.assertSame(1,result);
    }
    @Test
    @Transactional
    void delById() {
        int result = userMapper.delById(2);
        Assertions.assertSame(1,result);
    }

    @Test
    void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("老六");
        userInfo.setPassword("888");
        int result = userMapper.add(userInfo);
        Assertions.assertSame(1,result);
    }

    @Test
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

    @Test
    void login() {
        String username = "admin";
        String password = "' or 1='1";

        UserInfo userInfo = userMapper.login(username, password);
        System.out.println(userInfo);
    }

    @Test
    void getListByName() {
        String username = "a";
        List<UserInfo> list = userMapper.getListByName(username);
        for (UserInfo userInfo : list) {
            System.out.println(userInfo);
        }
    }

    @Test
    void getUserAndArticlesById() {
        Integer id = 1;
        UserInfo userInfo = userMapper.getUserAndArticlesById(id);
        log.info("用户信息：" + userInfo);
    }

    @Test
    void addUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("张无忌");
        userInfo.setPassword("12345611");
        userInfo.setPhoto("张无忌.png");
        int res = userMapper.addUser(userInfo);
        log.info("受影响的行数为:" + res);
    }

    @Test
    void addUser2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wangwu");
        userInfo.setPassword("12345622");
        int res = userMapper.addUser(userInfo);
        log.info("受影响的行数为:" + res);
    }

    @Test
    void updateUser() {
        UserInfo userInfo = new UserInfo();
        //修改密码为123456
        userInfo.setPassword("123456");
        userInfo.setId(1);
        int res = userMapper.updateUser(userInfo);
        log.info("受影响的行数：" + res);
    }

    @Test
    void deleteIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(10);
        ids.add(11);
        ids.add(12);

        int res = userMapper.deleteIds(ids);
        log.info("受影响的行数" + res);
    }
}