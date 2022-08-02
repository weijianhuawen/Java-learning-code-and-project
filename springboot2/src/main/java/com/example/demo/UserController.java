package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
public class UserController {
    @Value("${server.port}")
    private String port;

    @PostConstruct
    @ResponseBody   //返回一个非静态页面数据
    @RequestMapping("/getport")    //路由地址小写
    public String getPort() {
        return "端口号：" + port;
    }
}
