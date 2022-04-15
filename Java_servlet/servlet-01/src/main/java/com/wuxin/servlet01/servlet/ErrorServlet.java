package com.wuxin.servlet01.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: wuxin001
 * @Date: 2022/04/14/13:16
 * @Description:
 */
public class ErrorServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>404 NotFound<h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
    }
}
