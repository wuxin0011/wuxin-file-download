package com.wuxin.service.impl;

import com.wuxin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: wuxin001
 * @Date: 2022/04/30/18:21
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String username, String password) {
        return "admin".equals(username) && "123456".equals(password);
    }
}
