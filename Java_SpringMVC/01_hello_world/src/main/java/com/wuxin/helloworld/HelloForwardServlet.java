package com.wuxin.helloworld;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloForwardServlet", value = "/hello-forward")
public class HelloForwardServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "测试转发!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("经过转发..."+request.getRequestedSessionId());
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        request.getRequestDispatcher("index.jsp");
    }

    public void destroy() {
    }
}