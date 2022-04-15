package com.wuxin.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/0:58
 * @Description:
 */
public class CollectionTest01 {


    public static void main(String[] args) {
        // 默认空数组
        // ArrayList 底层是一维数组  private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
        Collection<String> arrayList = new ArrayList<>();

        // 添加
        arrayList.add("Linux");
        arrayList.add("Java");
        arrayList.add("Docker");
        System.out.println(arrayList);


        // 删除
        arrayList.remove("Java");
        System.out.println(arrayList);

        // 查找
        System.out.println(arrayList.contains("docker"));
        System.out.println(arrayList.contains("Docker"));
        System.out.println(arrayList.contains("Java"));

        //
        System.out.println(arrayList.size());


        // 删除全部
        // arrayList.removeAll();

        // 全部添加
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("remove");
        arrayList.addAll(arrayList1);

        //     修改
        // arrayList.

    }

}
