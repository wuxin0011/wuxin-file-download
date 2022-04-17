package com.wuxin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @Author: wuxin001
 * @Date: 2022/04/17/11:21
 * @Description:
 */
@WebServlet(name = "uploadServlet", value = "/upload/file")
public class UploadServlet extends HttpServlet {

    private static final String path = "image";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File(req.getParameter("file"));
        System.out.println(file);
        // 判断文件是否为null
        boolean exists = file.exists();
        if (exists) {
            System.out.println("file  exist");
        } else {
            System.out.println("file not exist");
        }
        String contextPath = getServletContext().getContextPath();
        System.out.println(contextPath);
        // 文件写入
        // 获取文件名
        // 获取文件后缀
        // 文件写入
        // 文件流关闭
    }
}
