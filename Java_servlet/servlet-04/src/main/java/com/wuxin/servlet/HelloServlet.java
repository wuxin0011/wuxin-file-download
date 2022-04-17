package com.wuxin.servlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author Administrator
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + session + "</h1>");
        out.println("<h1> 我是Servlet filter实现</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
    }
}