package com.wuxin.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: wuxin001
 * @Date: 2022/04/17/8:51
 * @Description: session
 */
@WebServlet("/test/session")
public class TestSessionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>用戶您当前session是:<span style='color:red;'>" + session + "</span></h1>");
        out.println("<h1>用戶<span style='color:red;'>" + session.getAttribute("username") + "</span></h1>");
        out.println("</body></html>");
    }
}
