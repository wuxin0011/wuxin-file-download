package com.wuxin.servlet01.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/18:10
 * @Description:
 */
public class TestServlet02 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<h2> servlet configName=>" + this.getServletName() + "</h2>");
        while (this.getInitParameterNames().hasMoreElements()) {
            String s = this.getInitParameterNames().nextElement();
            writer.println("<h2> init params key=>" + s + "</h2>");
            writer.println("<h2> init params value=>" + this.getInitParameter(s) + "</h2>");
            writer.println("<hr/>");
        }
    }
}