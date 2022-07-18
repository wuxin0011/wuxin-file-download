package com.wuxin.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: wuxin001
 * @date: 2022/7/16 20:58
 * @Description:
 */
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        filterChain.doFilter(request, response);
    }

}
