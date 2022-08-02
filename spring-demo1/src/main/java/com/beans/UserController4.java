package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

//@Controller
//public class UserController4 {
//    private User user;
//    @Autowired
//    public UserController4(@Qualifier(value = "userinfo") User user) {
//        this.user = user;
//    }
//
//    public void sayHi() {
//        System.out.println("User" + user);
//    }
//}

@Controller
public class UserController4 {
    private User user;
    @Autowired
    public UserController4(User userinfo) {
        this.user = userinfo;
    }

    public UserController4() {
        System.out.println("Hi");
    }

    public void sayHi() {
        System.out.println("User" + user);
    }
}
