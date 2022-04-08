package com.wuxin.list;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/17:58
 * @Description:
 */
public class ListDemo03 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("user1");
        arrayList.add("user2");
        arrayList.add("user3");
        arrayList.add("user4");
        arrayList.add("user5");

        System.out.println(arrayList);
        arrayList.set(1, null);
        // 普通方法是删除不了 ,这个方法将将内容地址置换为null
        System.out.println(arrayList);
        // 调用remove删除 调用了GC
        arrayList.remove(1);
        System.out.println(arrayList);


        Collection<Object> collection1 = new ArrayList<>();
        add(collection1, "hello");
        add(collection1, 1);
        add(collection1, 100);
        add(collection1, 100);
        add(collection1, 100L);
        add(collection1, 100.00);
        System.out.println(collection1);

        // remove方法之删除第一个匹配的内容 remove之所以能够删除 是因为调用了 GC
        // collection1.remove(100);
        // collection1.remove("hello");


        System.out.println(collection1);
    }

    static void add(Collection<Object> collection, Object o) {
        collection.add(o);
    }
}
