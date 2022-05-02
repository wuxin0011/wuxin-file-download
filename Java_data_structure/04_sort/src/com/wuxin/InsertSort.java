package com.wuxin;

import java.util.Arrays;

/**
 * @Author: wuxin001
 * @Date: 2022/04/22/17:17
 * @Description: 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] ints = {1, 100, 10, -29, 200, 199, 33, 4, 22};
        insertSort(ints);
        testTime();

    }

    public static void insertSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int insertValue = ints[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < ints[insertIndex]) {
                ints[insertIndex + 1] = ints[insertIndex];
                insertIndex--;
            }
            ints[insertIndex + 1] = insertValue;
        }
        // System.out.println(Arrays.toString(ints));
    }

    public static void testTime() {
        long l1 = System.currentTimeMillis();

        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * ints.length);
        }
        insertSort(ints);

        long l2 = System.currentTimeMillis();
        System.out.println("time:" + (l2 - l1) + "ms");

    }
}
