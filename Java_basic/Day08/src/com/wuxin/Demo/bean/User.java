package com.wuxin.Demo.bean;

/**
 * @Author: wuxin001
 * @Date: 2022/04/05/12:43
 * @Description:
 */
public class User {
    public Integer userid;
    public String name;
    public String password;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
