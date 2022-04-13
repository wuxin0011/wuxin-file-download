package com.wuxin.demo.bean;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/17:11
 * @Description:
 */
public class User {
    public int id;
    private String password;
    public String name;

    public User(int id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
