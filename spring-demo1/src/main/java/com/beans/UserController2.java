package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController2 {
    @Autowired
    @Qualifier(value = "userinfo")
    private User user;

    public void sayHi() {
        System.out.println("User" + user);
    }
}
