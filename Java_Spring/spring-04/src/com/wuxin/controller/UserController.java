package com.wuxin.controller;

import com.wuxin.service.UserService;
import com.wuxin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:42
 * @Description:
 */
@Component(value = "userController")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录api调用 业务层
     * @param username username
     * @param password password
     * @return true
     */
    public boolean isLogin(String username, String password) {
        return userService.login(username, password);
    }
}
