package com.wuxin.service;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:37
 * @Description:
 */
public interface UserService {

    /**
     * 登录 业务层
     * @param username username
     * @param password password
     * @return true
     */
    boolean login(String username,String password);
}
