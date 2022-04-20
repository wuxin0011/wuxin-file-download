package com.wuxin.bean;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/22:21
 * @Description:
 */
public class Person {

    private int userid;

    public Person(int userid) {
        this.userid = userid;
    }

    public Person() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
