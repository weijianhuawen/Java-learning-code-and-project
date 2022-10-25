package com.example.musicdemo.controller;


import com.example.musicdemo.model.UserLogin;
import com.example.musicdemo.tools.ResponseBodyMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {


    @RequestMapping("login")
    public ResponseBodyMessage<UserLogin> login(@RequestParam String username, @RequestParam String password) {
        //login
        if (username == null || password == null) {
            return new ResponseBodyMessage<>(-1, "参数为空！", null);
        }

        UserLogin user = new UserLogin();
        if (username.equals("111") && password.equals("222")) {
            user.setUsername(username);
            user.setPassword(password);
            return new ResponseBodyMessage<>(1, "验证成功", user);
        } else {
            return new ResponseBodyMessage<>(-1, "登录失败", user);
        }
    }
}
