package com.wuxin.servlet;

import com.wuxin.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: wuxin001
 * @Date: 2022/04/14/15:22
 * @Description: login 请求接口
 */
@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    public LoginServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // 从request请求中获取请求信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.login(username, password)) {
            // 登录成功
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            //    登录失败
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<h2>对不起，登录失败！</h2>");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
