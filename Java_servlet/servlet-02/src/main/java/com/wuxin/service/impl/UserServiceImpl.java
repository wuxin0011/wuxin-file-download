package com.wuxin.service.impl;

import com.wuxin.service.UserService;

import javax.jws.WebService;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/9:53
 * @Description:
 */
@WebService
public class UserServiceImpl implements UserService {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";

    @Override
    public boolean login(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
