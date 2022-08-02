package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.Oneway;
import java.util.HashMap;

@RestController
public class UserController {
    @RequestMapping("/user")
    public String sayHi() {
        return "时间戳:" + System.currentTimeMillis();
    }
    @RequestMapping("/login")
    public HashMap<String, Object> login(@RequestBody User user) {
        HashMap<String, Object> result = new HashMap<>();
        int state = 200;
        boolean isOk = true;
        String reason = "登录成功!";
        if (user.userName == null || user.password == null || "".equals(user.userName) || "".equals(user.password)) {
            //密码或用户名为空
            isOk =false;
            reason = "用户名或密码为空!";
            result.put("state", state);
            result.put("isOk", isOk);
            result.put("reason", reason);
            return result;
        }

        if (!"admin".equals(user.userName) || !"admin".equals(user.password)) {
            isOk =false;
            reason = "用户名或密码错误!";
            result.put("state", state);
            result.put("isOk", isOk);
            result.put("reason", reason);
            return result;
        }
        return result;
    }


}
