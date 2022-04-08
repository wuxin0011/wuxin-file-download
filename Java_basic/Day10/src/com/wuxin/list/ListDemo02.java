package com.wuxin.list;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/17:59
 * @Description:
 */
public class ListDemo02 {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        isContains(arrayList, "admin");

        arrayList.add("user1");
        arrayList.add("user2");
        arrayList.add("user3");
        arrayList.add("user4");

        String name1 = new String("user3");
        String name2 = "user4";
        String name3 = "user5";

        isContains(arrayList, name1);
        isContains(arrayList, name2);
        isContains(arrayList, name3);
    }

    static void isContains(ArrayList<String> arrayList, String content) {
        if (arrayList.size() == 0) {
            System.out.println("列表为空！");
            return;
        }
        if (arrayList.contains(content)) {
            System.out.println(content + "在列表中");
        } else {
            System.err.println(content + "不在列表中");
        }
    }
}
