package com.wuxin.set;

import com.wuxin.bean.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/23:43
 * @Description:
 */
public class SetDemo01 {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        set.add(new User(1));
        set.add(new User(2));
        set.add(new User(3));
        set.add(new User(4));

        System.out.println(set);

    }
}


