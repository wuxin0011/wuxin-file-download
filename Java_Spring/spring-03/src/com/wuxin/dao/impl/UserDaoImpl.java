package com.wuxin.dao.impl;

import com.wuxin.dao.UserDao;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:50
 * @Description:
 */
public class UserDaoImpl implements UserDao {

    @Override
    public boolean login(String username, String password) {
        return "admin".equals(username) && "123456".equals(password);
    }
}
