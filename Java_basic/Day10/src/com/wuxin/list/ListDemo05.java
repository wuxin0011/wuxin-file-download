package com.wuxin.list;

import java.util.ArrayList;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/23:26
 * @Description:
 */
public class ListDemo05 {

    public static void main(String[] args) {
        ArrayList<Person> users = new ArrayList<>();
        users.add(new Person("user1"));
        users.add(new Person("user2"));
        users.add(new Person("user3"));
        users.add(new Person("user4"));
        users.add(new Person("user5"));

        System.out.println(users);

        // 根据对象内容删除 发现无法删除 原因是 remove 方法是根据 Object.equals() 所以必须要重写equals方法
        // 重写了equals方法
        users.remove(new Person("user1"));
        System.out.println(users);
    }
}


class Person {
    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * 删除内容需要重写equals方法 假设对象名称相等判断为同一个对象
     */
    @Override
    public boolean equals(Object obj) {
        // 不能为空
        if (obj == null) {
            return false;
        }
        // 如果调用为当前对象
        if (this == obj) {
            return true;
        }
        // 下转型
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return !this.name.isEmpty() && !person.name.isEmpty() && this.name.equals(person.name);
        }
        return false;
    }
}

