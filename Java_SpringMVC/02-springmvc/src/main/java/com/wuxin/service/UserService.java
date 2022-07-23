package com.wuxin.service;

import com.wuxin.bean.BaseService;
import com.wuxin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    User isLogin(String email, String password);



    /**
     * 通过主键查询用户
     *
     * @param id 主键id
     * @return DTO
     */
    User queryOne(int id);


    /**
     * @param email 关键词
     * @return DTO
     */
    User queryUserByEmail(String email);


    /**
     * @param username 关键词
     * @return DTO
     */
    User queryUserByName(String username);

    /**
     * @param keywords 关键词
     * @return DTO
     */
    List<User> queryUserByEmailOrName(String keywords);


}
