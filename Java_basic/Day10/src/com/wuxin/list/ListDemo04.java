package com.wuxin.list;

import java.util.ArrayList;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/23:16
 * @Description:
 */
public class ListDemo04 {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("user1"));
        users.add(new User("user2"));
        users.add(new User("user3"));
        users.add(new User("user4"));
        users.add(new User("user5"));

        System.out.println(users);

        // 根据对象内容删除 发现无法删除 原因是 remove 方法是根据 Object.equals() 所以必须要重写equals方法
        // 成功删除案例见 ListDemo05 重写equals方法
        users.remove(new User("user1"));
        System.out.println(users);
    }
}

class User {
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
