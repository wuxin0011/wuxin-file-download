package com.wuxin.service;

/**
 * @Author: wuxin001
 * @Date: 2022/04/30/18:20
 * @Description:
 */

public interface UserService {

    /**
     * login
     * @param username username
     * @param password password
     * @return true
     */
    boolean login(String username,String password);
}
