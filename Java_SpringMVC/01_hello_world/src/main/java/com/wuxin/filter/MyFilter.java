package com.wuxin.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @author: wuxin001
 * @date: 2022/7/14 0:33
 * @Description:
 */
@WebFilter("/**")
public class MyFilter extends HttpFilter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("经过自定义过滤器");
        req.setCharacterEncoding("utf-8");
        res.setCharacterEncoding("utf-8");
        super.doFilter(req, res, chain);
    }
}
