package com.wuxin.controller;

import com.wuxin.dao.UserDao;
import com.wuxin.dao.impl.UserDaoImpl;
import com.wuxin.service.UserService;
import com.wuxin.service.impl.UserServiceImpl;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:42
 * @Description:
 */
public class UserController {

    /**
     * 登录api调用 业务层
     * @param username username
     * @param password password
     * @return true
     */
    public boolean isLogin(String username, String password) {
        UserService userService = new UserServiceImpl();
        return userService.login(username, password);
    }
}
