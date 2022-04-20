package com.wuxin.service.impl;

import com.wuxin.dao.UserDao;
import com.wuxin.dao.impl.UserDaoImpl;
import com.wuxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:37
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(String username, String password) {
        return  userDao.login(username,password);
    }


}
