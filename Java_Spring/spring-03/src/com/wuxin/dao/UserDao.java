package com.wuxin.dao;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:37
 * @Description:
 */
public interface UserDao {

    /**
     * 登录 管理层 直接操作数据库
     * @param username username
     * @param password password
     * @return true
     */
    boolean login(String username, String password);
}
