package com.wuxin.collection;

import java.util.LinkedList;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/1:11
 * @Description: 测试 collection列表子类 LinkedList， 底层是双向链表
 */
public class CollectionTest02 {

    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        // 添加
        strings.add("Java");
        strings.add("docker");
        strings.add("css");
        strings.add("html");

        System.out.println(strings);

        // 删除
        String remove = strings.remove(2);
        System.out.println("删除了" + remove);
        System.out.println(strings);

        //    修改
        strings.set(1,"hello");
        System.out.println(strings);

        // 查找
        System.out.println(strings.contains("docker"));

        // 获取
        System.out.println(strings.get(1));

        // 元素个数
        System.out.println(strings.size());
    }
}
