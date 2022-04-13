package com.wuxin.bean;

/**
 * @Author: wuxin001
 * @Date: 2022/04/10/22:25
 * @Description:
 */
public class User{
    private String username;
    private int userid;

    public User() {
    }

    public User(String username, int userid) {
        this.username = username;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userid=" + userid +
                '}';
    }
}
