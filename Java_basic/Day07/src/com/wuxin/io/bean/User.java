package com.wuxin.io.bean;

import java.io.Serializable;

/**
 * @Author: wuxin001
 * @Date: 2022/03/28/12:12
 * @Description:
 */
public class User implements Serializable {

    // 加入序列化id是为了防止User类代码修改 无法反序列化以前序列化对象
    private static final long serialVersionUID = 8683452581122892181L;


    private Integer userid;
    private String username;

    public User() {

    }

    public User(Integer userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                '}';
    }
}
