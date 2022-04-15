package com.wuxin.service;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/9:51
 * @Description:
 */
public interface UserService {

    /**
     * 假设模拟登陆
     * @param username username
     * @param password passsword
     * @return true
     */
    boolean login(String username,String password);
}
