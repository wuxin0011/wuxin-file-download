package com.wuxin.arr;

import java.util.Arrays;

/**
 * @Author: wuxin001
 * @Date: 2022/03/22/23:40
 * @Description: 冒泡排序
 */
public class Demo04 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 20, 3, 9};
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int i1 = 0; i1 < arr.length - 1 - i; i1++) {
                if (arr[i1] > arr[i1 + 1]) {
                    temp = arr[i1];
                    arr[i1] = arr[i1 + 1];
                    arr[i1 + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append(",");
        stringBuilder.append(2);
        System.out.println(stringBuilder);
    }
}
