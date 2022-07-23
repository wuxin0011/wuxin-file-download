package com.wuxin.mapper;

import com.wuxin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/15 9:45
 * @Description:
 */
public interface UserMapper {


    /**
     * 根据用户名模糊查询用户
     *
     * @param username 用户名
     * @return 用户列表 list
     */
    List<User> list(@Param("username") String username);

    /**
     * 通过主键查询用户
     *
     * @param id 主键id
     * @return DTO
     */
    User queryOne(@Param("id") int id);


    /**
     * 根据邮箱查询用户
     * @param email 关键词
     * @return DTO
     */
    User queryUserByEmail(@Param("email") String email);


    /**
     * 根据用户名查询用户
     * @param username 关键词
     * @return DTO
     */
    User queryUserByName(@Param("username") String username);

    /**
     * 根据用户名或者邮箱查询用户
     * @param keywords 关键词
     * @return DTO
     */
    List<User> queryUserByEmailOrName(@Param("keywords") String keywords);

    /**
     * 用户登录
     *
     * @param email    邮箱
     * @param password 密码
     * @return DTO
     */
    User login(@Param("email") String email, @Param("password") String password);

    /**
     * 用户信息修改
     *
     * @param user DTO
     * @return 1
     */
    int update(User user);

    /**
     * 添加用户
     *
     * @param user DTO
     * @return 1
     */
    int add(User user);

    /**
     * 删除用户
     *
     * @param id id
     * @return 1
     */
    int delete(@Param("id") int id);


    /**
     * 修改用户状态
     * @param id id
     * @param status 状态
     * @return true
     */
    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}
