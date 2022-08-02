package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController1 {
    //属性注入
    @Autowired
    private UserService service;

    public void sayHi() {
        service.sayHi();
    }
}
