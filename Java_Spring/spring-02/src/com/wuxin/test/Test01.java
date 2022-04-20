package com.wuxin.test;

import com.wuxin.controller.UserController;

/**
 * @Author: wuxin001
 * @Date: 2022/04/20/6:01
 * @Description:
 */
public class Test01 {



    public static void main(String[] args) {
        UserController userController = new UserController();
        boolean admin  = userController.isLogin("admin", "123456");
        if(admin){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

    }
}
