package com.wuxin.demo.demo09;

import java.util.Objects;

/**
 * @Author: wuxin001
 * @Date: 2022/04/07/9:34
 * @Description:
 */
public class Demo09 {
    public static void main(String[] args) {
        // Object对象的toString方法
        // public String toString() {
        //     return getClass().getName() + "@" + Integer.toHexString(hashCode());
        // }
        User user = new User("12321313213", "张三");
        User newUser = new User("12321313213", "李四");
        System.out.println("User==newUser" + (user.equals(newUser)));
        System.out.println(user);
        // 输出对象默认调用的是toString方法
        System.out.println(user.toString());
        String hello = new String("hello");
        // String 类重写了Object toString方法
        // String 对象 toString方法
       // String
        System.out.println(hello);
        System.out.println(hello.toString());
        System.out.println(hello == hello.toString());
    }
}

class User {

    private String idCard;
    private String name;

    public User(String idCard, String name) {
        this.idCard = idCard;
        this.name = name;
    }


    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 重写Object对象toString方法
    @Override
    public String toString() {
        return "this.toString()";
    }


    @Override
    public boolean equals(Object o) {
        // 重写equal方法 比较User对象id是否相等，如果相等，说明是是同一个对象
        if (o instanceof User) {
            User user = (User) o;
            System.out.println("this" + this.getName() + "this.id" + this.getIdCard() + "this.toString()" + this.getIdCard().toString());
            System.out.println("name" + user.getName() + "name.id" + user.getIdCard() + "id.toString()" + user.getIdCard().toString());
            // 防止空指针异常
            if (this.getIdCard().isEmpty() || user.getIdCard().isEmpty()) {
                return false;
            }
            return this.getIdCard().equals(user.getIdCard());
        }
        return false;
    }


}