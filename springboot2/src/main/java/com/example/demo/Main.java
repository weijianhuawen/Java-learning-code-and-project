package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Main {
    @ResponseBody   //返回一个非静态页面数据
    @RequestMapping("/sayhai")    //路由地址小写
    public static String sayHi() {
        return "hello world";
    }
}
