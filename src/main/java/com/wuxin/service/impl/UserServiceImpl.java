package com.wuxin.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.wuxin.mapper.UserMapper;
import com.wuxin.pojo.User;
import com.wuxin.service.UserService;
import com.wuxin.utils.MD5Util;
import com.wuxin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserMapper userMapper;


    @Override
    public User isLogin(String email, String password) {
        return userMapper.login(email, MD5Util.md5DigestAsHex(password));
    }

    @Override
    public boolean add(User user) {
        user.setPassword(MD5Util.md5DigestAsHex(user.getPassword()));
        return userMapper.add(user) >= 1;
    }

    @Override
    public boolean update(User user) {
        if (!StringUtil.isEmpty(user.getPassword())) {
            user.setPassword(MD5Util.md5DigestAsHex(user.getPassword()));
        }
        return userMapper.update(user) >= 1;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.delete(id) >= 1;
    }

    @Override
    public List<User> list(String name) {
        return userMapper.list(name);
    }

    @Override
    public User queryOne(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.queryOne(id);
    }

    @Override
    public User queryUserByEmail(String email) {
        return userMapper.queryUserByEmail(email);
    }

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    @Override
    public List<User> queryUserByEmailOrName(String keywords) {
        return userMapper.queryUserByEmailOrName(keywords);
    }

    @Override
    public boolean updateStatus(Integer id, Integer status) {
        return userMapper.updateStatus(id, status) >= 1;
    }
}
