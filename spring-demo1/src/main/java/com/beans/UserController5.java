package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController5 {
    private User user;

    @Autowired
    public void setUser(User userinfo) {
        this.user = userinfo;
    }

    public void sayHi() {
        System.out.println("User" + this.user);
    }
}
