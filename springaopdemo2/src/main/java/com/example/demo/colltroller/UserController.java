package com.example.demo.colltroller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public boolean login(String username, String password, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        System.out.println(username);
        System.out.println(password);
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password) && username.equals("admin") && password.equals("admin")) {
            session.setAttribute("userinfo", "userinfo");
            return true;
        }
        return false;
    }
    //算术异常
    @RequestMapping("/ae")
    public double add() {
        double a = 10/4;
        return a;
    }
    //其他异常
    @RequestMapping("/nulle")
    public void setObject() {
        List<Integer> list= null;
        list.add(999);
    }

    //随便返回一个数据
    @RequestMapping("/index")
    public int index() {
        return 1;
    }

    @RequestMapping("/reg")
    public String reg() {
        return "注册成功!";
    }
}
