package com.wuxin.helloworld;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloRedirectServlet", value = "/hello-redirect")
public class HelloRedirectServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "测试 redirect!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("经过重定向..."+request.getRequestedSessionId());

        response.sendRedirect("index.jsp");
    }

    public void destroy() {
    }
}