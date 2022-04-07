package com.wuxin.demo;

/**
 * 抽象类
 * 1、什么是抽象类？ 什么是类？什么是抽象类？
 *  类和类之间共同特征提取出来，形成的类就是抽象类
 *
 *  2、抽象类子类也可以是抽象类
 *  3、
 *
 *
 * @Author: wuxin001
 * @Date: 2022/04/06/19:44
 * @Description:
 */
public class Demo03 {
    public static void main(String[] args) {
        new Student().setUsername("admin0");
        new Student().setUsername("admin1");
        new Student().setUsername("admin2");
        new Student().setUsername("admin3");

        // 抽象类无法创建对象
        Person person = new Person() {
            @Override
            void setUsername(String username) {
                System.out.println(username + "是一个人");
            }
        };

        person.setUsername("person1");
        person.sleep("person1");
        person.setUsername("person2");
        person.sleep("person2");
        person.setUsername("person3");
        person.sleep("person3");
        person.setUsername("person4");
        person.sleep("person4");

        // 抽象类无法创建对象，抽象类是用来继承的
        // Father father = new Father();
    }
}

abstract class Person {

    abstract void setUsername(String username);

    // 抽象类中可以有具体方法实现
    void sleep(String name) {
        System.out.println(name + "在睡觉");
    }
}

class Student extends Person {

    // 必须要实现抽象类方法 否则报错
    @Override
    void setUsername(String username) {
        System.out.println("学生姓名是:" + username);
    }
}

abstract class Father{

}
