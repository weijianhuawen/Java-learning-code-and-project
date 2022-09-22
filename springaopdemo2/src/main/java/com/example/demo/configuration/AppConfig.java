package com.example.demo.configuration;

//import com.example.demo.interceptor.LoginInterceptor;
import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    //拦截器对象
    @Autowired
    private LoginInterceptor loginInterceptor;
    //添加拦截器的拦截条件

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**") //拦截所有资源
                .excludePathPatterns("/user/login") //不拦截登录注册接口
                .excludePathPatterns("/user/reg")
                .excludePathPatterns("/user/index")
                .excludePathPatterns("/login.html") //不拦截登录与注册页面
                .excludePathPatterns("/reg.html")
                .excludePathPatterns("/**/**.js") //不拦截静态资源文件，如js，css文件
                .excludePathPatterns("/**/**.css")
                .excludePathPatterns("/img"); //不拦截图片资源
    }
}
