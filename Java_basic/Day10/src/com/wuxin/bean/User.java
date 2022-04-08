package com.wuxin.bean;

import java.util.Objects;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/8:53
 * @Description:
 */
public class User implements Cloneable {
    private int id;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return this;
    }
}
