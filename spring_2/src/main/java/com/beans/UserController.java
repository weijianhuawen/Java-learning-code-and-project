package com.beans;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    public void sayHi(String name) {
        System.out.println("你好!" + name);
    }
}
