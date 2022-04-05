package com.wuxin.Demo;

import com.wuxin.Demo.bean.User;

/**
 * @Author: wuxin001
 * @Date: 2022/04/01/19:41
 * @Description:
 */
public class Demo03 {
    public static void main(String[] args) {
        int i = 10;
        System.out.println("i------>" + i);
        Integer i1 = (Integer) i;
        System.out.println("i1.hashcode="+i1.hashCode());
        add(i);
        Integer i2 = (Integer) i;
        System.out.println(" i=>" + i + "i1.hashcode=" + i1.hashCode()+",i2.hashcode="+i2.hashCode());

        Integer b = i;
        System.out.println("delete b1=>" + b + ",hashcode=" + b.hashCode());
        delete(b);
        System.out.println("delete b2=>" + b + ",hashcode=" + b.hashCode());

        User user = new User();
        System.out.println("user=======>" + user + ",user.hashCode=>" + user.hashCode());
        Demo03 demo03 = new Demo03();
        demo03.createUser(user);
        System.out.println("user=======>" + user + ",user.hashCode=>" + user.hashCode());
    }

    static void add(int i) {
        Integer i1 = (Integer) i;
        i++;
        Integer i2 = (Integer) i;
        System.err.println("add i=>" + i + "i1.hashcode=" + i1.hashCode()+",i2.hashcode="+i2.hashCode());
    }

    static void delete(Integer i) {
        System.out.println("delete i=>" + i + ",hashcode=" + i.hashCode());
        i--;
        System.out.println("delete i=>" + i + ",hashcode=" + i.hashCode());
    }

    void createUser(User user) {
        user.userid = 100;
        user.password = "admin";
        user.name = "admin";
        System.out.println("createUser=======>" + user + ",createUser.hashCode=>" + user.hashCode());
    }
}
