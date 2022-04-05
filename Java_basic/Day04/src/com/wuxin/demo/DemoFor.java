package com.wuxin.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wuxin001
 * @Date: 2022/03/23/12:56
 * @Description: for循环
 */
public class DemoFor {

    private final static List<String> STRING_LIST = new ArrayList<>();
    private final static List<String> TIME_LIST = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test();
        }
        System.err.println(TIME_LIST);
    }


    private static void test() {
        long start = System.currentTimeMillis();
        create();
        test01();
        long end = System.currentTimeMillis();
        TIME_LIST.add((end - start)+"ms");
        System.out.println("时间:" + (end - start) + "ms");
    }

    private static void create() {
        for (int i = 0; i < 1000; i++) {
            STRING_LIST.add(Integer.toString(i));
        }
    }


    private static void test01() {
        for (String s : STRING_LIST) {
            System.out.println(s);
        }
    }

}
