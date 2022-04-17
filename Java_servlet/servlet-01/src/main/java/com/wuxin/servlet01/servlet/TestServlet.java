package com.wuxin.servlet01.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/17:34
 * @Description:
 */
public class TestServlet extends GenericServlet {


    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("request=======>" + request);
        System.out.println(request.getServletContext().getContextPath());
        System.out.println("config=>" + getServletConfig());
        ServletConfig servletConfig = getServletConfig();
        System.out.println("configName=>" + servletConfig.getServletName());
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        // System.out.println(initParameterNames);
        System.out.println("init params name=>" + initParameterNames.getClass().getName());

        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<h2> servlet configName=>" + servletConfig.getServletName() + "</h2>");
        while (initParameterNames.hasMoreElements()) {
            String s = initParameterNames.nextElement();
            writer.println("<h2> init params key=>" + s + "</h2>");
            writer.println("<h2> init params value=>" + servletConfig.getInitParameter(s) + "</h2>");
            writer.println("<hr/>");
        }

    }
}
