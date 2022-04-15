package com.wuxin.print;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/0:01
 * @Description: 测试
 */
public class Demo01 {


    private static final User USER = null;


    private Demo01() {

    }

    private static void setUser() {
        new User("admin", "123456");
    }


    private static void init() {

    }


}

class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
