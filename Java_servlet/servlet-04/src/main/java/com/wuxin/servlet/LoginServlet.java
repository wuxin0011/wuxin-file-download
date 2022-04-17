package com.wuxin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: wuxin001
 * @Date: 2022/04/17/9:27
 * @Description:
 */
@WebServlet(value = "/login", name = "loginServlet")
public class LoginServlet extends HttpServlet {
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "123456";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            resp.setStatus(200);
            resp.setContentType("application/json");
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
        } else {
            resp.setStatus(500);
            resp.setContentType("application/json");
        }
    }
}
