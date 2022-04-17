package com.wuxin.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @Author: wuxin001
 * @Date: 2022/04/17/12:57
 * @Description: 设置所有请求支持中文
 */
@WebFilter("*")
public class MyFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 设置请求编码为utf-8
        res.setCharacterEncoding("utf-8");
        // 不执行该方法，只会执行一个过滤器
        chain.doFilter(req, res);
    }
}
