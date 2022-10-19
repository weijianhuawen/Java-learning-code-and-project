package com.example.musicdemo.controller;


import com.example.musicdemo.mapper.UserMapper;
import com.example.musicdemo.model.UserLogin;
import com.example.musicdemo.tools.Constant;
import com.example.musicdemo.tools.ResponseBodyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserLoginController {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("login1")
    public ResponseBodyMessage<UserLogin> login1(@RequestParam String username, @RequestParam String password, HttpServletRequest req) {
        //非空校验
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return new ResponseBodyMessage<>(-1, "密码或用户名为空!", null);
        }


        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(username);
        userLogin.setPassword(password);
        //数据库查询
        UserLogin user = userMapper.login(userLogin);

        if (user != null) {
            //登录成功
            //设置Session
            req.getSession().setAttribute(Constant.USERINFO_SESSION_KEY, user);
            return new ResponseBodyMessage<>(1, "登录成功!", user);

        } else {
            //登录失败
            return new ResponseBodyMessage<>(-1, "登录失败!", user);
        }
    }

    @RequestMapping("login")
    public ResponseBodyMessage<UserLogin> login(@RequestParam String username, @RequestParam String password, HttpServletRequest req) {
        //非空校验
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return new ResponseBodyMessage<>(-1, "密码或用户名为空!", null);
        }


//        UserLogin userLogin = new UserLogin();
//        userLogin.setUsername(username);
//        userLogin.setPassword(password);
        //数据库查询
        UserLogin user = userMapper.getUserByName(username);

        if (user != null) {
            //进行验证
            //设置Session
            boolean ret = bCryptPasswordEncoder.matches(password, user.getPassword());
            if (!ret) {
                //密码错误
                return new ResponseBodyMessage<>(-1, "用户账户名或密码错误!", user);
            }
            //验证通过
            req.getSession().setAttribute(Constant.USERINFO_SESSION_KEY, user);
            return new ResponseBodyMessage<>(1, "登录成功!", user);

        } else {
            //登录失败
            return new ResponseBodyMessage<>(-1, "登录失败!", user);
        }
    }
}
