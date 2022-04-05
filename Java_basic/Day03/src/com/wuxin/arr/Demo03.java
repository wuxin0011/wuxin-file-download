package com.wuxin.arr;

import jdk.nashorn.internal.ir.IndexNode;

import java.util.Arrays;

/**
 * @Author: wuxin001
 * @Date: 2022/03/22/23:27
 * @Description:
 */
public class Demo03 {

    public static void main(String[] args) {
        int[] arr = {1, 10, 20, 100};
        int insertNum = 21;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (insertNum > arr[i] && insertNum < arr[i + 1]) {
                index = i + 1;
            }
        }

        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = arr[i];
            }
            if (i == index) {
                newArr[i] = insertNum;
            }
            if (i > index) {
                newArr[i] = arr[i - 1];
            }
        }

        System.out.println(Arrays.toString(newArr));
    }
}
