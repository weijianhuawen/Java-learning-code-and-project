package com.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {
    @Bean
    public User user1() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }

    @Bean(name = {"userinfo", "userdemo"})
    public User getUser() {
        User user = new User();
        user.setId(2);
        user.setName("李四");
        return user;
    }
}
