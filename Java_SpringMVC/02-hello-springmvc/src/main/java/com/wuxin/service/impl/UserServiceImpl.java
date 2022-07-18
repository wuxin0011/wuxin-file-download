package com.wuxin.service.impl;

import com.wuxin.pojo.User;
import com.wuxin.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/14 10:34
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    // @Autowired
    // private UserMapper userMapper;

    @Override
    public boolean isLogin(String email, String password) {
        return "2191377759@qq.com".equals(email) && "123456".equals(password);
    }

    @Override
    public boolean add(User user) {
        return UserService.super.add(user);
    }

    @Override
    public boolean update(User user) {
        return UserService.super.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return UserService.super.delete(id);
    }

    @Override
    public List<User> list() {
        return new ArrayList<>();
    }
}
