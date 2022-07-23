package com.wuxin.test.interceptior;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author: wuxin001
 * @date: 2022/7/20 10:52
 * @Description:
 */
public class GlobalHandlerInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // System.out.println("request信息=》" + Arrays.toString(request.getCookies()));
        // System.out.println("request信息=》" + request.getSession());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
