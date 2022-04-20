package com.wuxin.bean;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:17
 * @Description:
 */
public class Student {

    private String username;
    private int userid;

    public Student(String username, int userid) {
        this.username = username;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", userid=" + userid +
                '}';
    }
}
