package com.example.musicdemo.config;

import com.example.musicdemo.tools.Constant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 请求前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        //如果返回false 执行到这个拦截器就不会在执行controller
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute(Constant.USERINFO_SESSION_KEY) != null) {
            //登录成功
            return true;
        }
        //重定向到登录页面
        response.sendRedirect(request.getContextPath() + "/login.html");
        return false;
    }
}
