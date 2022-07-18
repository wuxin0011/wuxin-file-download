package com.wuxin.service;

import com.wuxin.bean.BaseService;
import com.wuxin.pojo.User;

/**
 * @author: wuxin001
 * @date: 2022/7/14 10:34
 * @Description:
 */
public interface UserService extends BaseService<User> {


    /**
     * login test
     *
     * @param email    email
     * @param password password
     * @return true success
     */
    boolean isLogin(String email, String password);
}
