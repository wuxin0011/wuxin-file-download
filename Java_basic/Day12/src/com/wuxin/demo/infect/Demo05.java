package com.wuxin.demo.infect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/15:06
 * @Description:
 */
public class Demo05 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<User> userClass = User.class;
        Method[] methods = userClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        // 获取对象
       // 通过反射机制操作对象方法
       //  获取构造器
        Constructor<?>[] constructors = userClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.err.println(constructor);
        }

        // 获取对象 调用无参数构造器 前提是User无参构造器能够访问要存在！
        User user = userClass.newInstance();
        user.setId(1);
        user.setUsername("admin");
        System.out.println(new User(1,"admin"));
    }
}

class User{
    private int id;
    private String username;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}

