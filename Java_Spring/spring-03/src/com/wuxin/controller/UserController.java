package com.wuxin.controller;

import com.wuxin.dao.UserDao;
import com.wuxin.dao.impl.UserDaoImpl;
import com.wuxin.service.UserService;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:42
 * @Description:
 */
public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    /**
     * 登录api调用 业务层
     *
     * @param username username
     * @param password password
     * @return true
     */
    public boolean isLogin(String username, String password) {
        return userService.login(username, password);
    }
}
