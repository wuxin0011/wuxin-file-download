package com.wuxin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: wuxin001
 * @Date: 2022/04/14/16:02
 * @Description: 重定向和转发
 */
// @WebServlet(name = "error", value = "/error")
public class ErrorServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Not Found request</h1>");
        out.println("</body></html>");

        /**
         * 重定向
         *  路径改变
         */
        // response.sendRedirect("/404.jsp");

        /**
         * 转发 路径不改变，内容发生改变
         */
        // request.getRequestDispatcher("/404.jsp").forward(request,response);
    }
}


