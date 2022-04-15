package com.wuxin.filter; /**
 * @Author: wuxin001
 * @Date: 2022/04/14/17:22
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter")
public class MyFilter extends GenericFilter {

    // @Override
    // public void init(FilterConfig config) throws ServletException {
    //     System.out.println("iit");
    // }
    //
    // @Override
    // public void destroy() {
    // }
    //
    // @Override
    // public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    //     HttpServletRequest request = (HttpServletRequest) req;
    //     HttpServletResponse response = (HttpServletResponse) resp;
    //     //解决POST请求乱码
    //     request.setCharacterEncoding("UTF-8");
    //     //解决响应乱码
    //     response.setContentType("text/html;charset=utf-8");
    //     //解决get乱码
    //     chain.doFilter(request,response);
    // }


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //解决POST请求乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应乱码
        response.setContentType("text/html;charset=utf-8");
        //解决get乱码
        filterChain.doFilter(request, response);
    }
}
