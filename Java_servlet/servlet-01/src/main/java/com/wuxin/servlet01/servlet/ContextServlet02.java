package com.wuxin.servlet01.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/18:18
 * @Description:
 */
public class ContextServlet02 extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletContext servletContext = this.getServletConfig().getServletContext();
        System.out.println(servletContext);
        System.out.println(this.getServletContext());

        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("content02:<h2>" + servletContext + "</h2>");
    }
}
