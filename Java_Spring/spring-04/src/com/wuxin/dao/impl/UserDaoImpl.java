package com.wuxin.dao.impl;

import com.wuxin.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:50
 * @Description:
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String username, String password) {
        return "admin".equals(username) && "123456".equals(password);
    }
}
