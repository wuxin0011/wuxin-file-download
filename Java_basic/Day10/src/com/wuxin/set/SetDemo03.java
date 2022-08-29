package com.wuxin.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: wuxin001
 * @Date: 2022/04/14/22:13
 * @Description: set与list不同是不可以重复 list是可以重复的
 */
@SuppressWarnings({"all"})
public class SetDemo03 {

    public static void main(String[] args) {


        List<String> arrayList = new ArrayList<>();
        arrayList.add("wuxin001");
        arrayList.add("wuxin001");
        arrayList.add("wuxin001");
        arrayList.add("wuxin001");
        arrayList.add("wuxin002");

        // 输出结果，list是可以重复的集合
        // System.out.println(arrayList.toString()); // 这里默认调用的是 AbstractCollection 抽象列的toString方法
        // [wuxin001, wuxin001, wuxin001, wuxin001, wuxin002]

        HashSet<String> strings = new HashSet<>();
        strings.add("wuxin001");
        strings.add("wuxin002");
        strings.add("wuxin002");
        strings.add("wuxin001");
        System.out.println(strings.toString()); // 这里默认调用的是 AbstractCollection 抽象列的toString方法
        // [wuxin001, wuxin002]
    }

}
