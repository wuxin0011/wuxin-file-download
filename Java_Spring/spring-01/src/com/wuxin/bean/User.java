package com.wuxin.bean;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/21:22
 * @Description:
 */
public class User {
    private int userid;
    private String username;
    private String password;
    private List<Cat> catList;

    public User() {
    }

    public User(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public List<Cat> getCatList() {
        return catList;
    }

    public void setCatList(List<Cat> catList) {
        this.catList = catList;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", catList='" + catList + '\'' +
                '}';
    }
}
