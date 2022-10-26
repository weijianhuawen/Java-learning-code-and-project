package com.example.musicdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        //拦截所有资源
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**") //拦截所有资源
                .excludePathPatterns("/css/**.css")//指定不拦截的资源如css，js，登录，注册页面等
                .excludePathPatterns("/js/**.js")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/font/**")
                .excludePathPatterns("/player/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/user/login");

    }
}
