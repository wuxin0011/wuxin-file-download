package com.wuxin.interceptor;

import com.wuxin.exception.AuthException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:09
 * @Description: 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("object handler=>" + handler.getClass());
        String uri = request.getRequestURI();
        if (!uri.contains("/admin")) {
            return true;
        }
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            throw new AuthException();
        }
        return true;
    }
}
