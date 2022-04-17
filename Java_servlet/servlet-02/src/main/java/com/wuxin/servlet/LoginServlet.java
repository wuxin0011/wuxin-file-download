package com.wuxin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Author: wuxin001
 * @Date: 2022/04/14/15:22
 * @Description: login 请求接口
 */
@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 从request请求中获取请求信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        if (isTrue(username, password)) {
            // 登录成功
            response.setStatus(200);
        } else {
            response.setStatus(500);
            writer.println("error");
        }

    }

    boolean isTrue(String username, String password) {
        return PASSWORD.equals(password) && USERNAME.equals(username);
    }
}
