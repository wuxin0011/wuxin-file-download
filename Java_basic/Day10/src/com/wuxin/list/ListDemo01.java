package com.wuxin.list;

import com.wuxin.bean.Person;
import com.wuxin.bean.User;

import java.util.*;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/8:47
 * @Description:
 */
public class ListDemo01 {
    public static void main(String[] args) throws Exception {

        list();

    }

    static void list(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        System.out.println(list);
        System.out.println(list.toString());
        list.add(3);
        list.add(4);
        System.out.println(list);

        // list.forEach();

    }

    static void cloneDemo() throws CloneNotSupportedException {
        Person person = new Person();
        Person clone = (Person) person.clone();
        System.out.println(clone.equals(person));

        User user = new User(1);
        Object clone1 = user.clone();
        System.out.println(clone1 instanceof User);
        System.out.println(user.equals((User) clone1));
    }
}
