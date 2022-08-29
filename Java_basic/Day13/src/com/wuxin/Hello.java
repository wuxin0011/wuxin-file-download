package com.wuxin;

import java.util.HashSet;

/**
 * @Author: wuxin001
 * @Date: 2022/04/29/19:02
 * @Description:
 */
public class Hello {


    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        set.add("Java");
        set.add("Java1");
        set.add("Java2");
        set.add("Java3");
        System.out.println("set=>"+set);
    }
}
