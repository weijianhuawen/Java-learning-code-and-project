package com.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController3 {
    @Resource(name = "userinfo")
    private User user;

    public void sayHi() {
        System.out.println("User" + user);
    }
}
