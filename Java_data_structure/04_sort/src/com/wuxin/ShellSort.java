package com.wuxin;

import java.util.Arrays;
import java.util.Currency;

/**
 * @Author: wuxin001
 * @Date: 2022/04/22/17:17
 * @Description: 希尔排序 (分组排序)
 */
public class Demo04 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 79, 10, 33, 44, 222, 5, 24};
        System.out.println(a.length);

        shellSort(a);
        testTime();

    }


    /**
     * 如果不优化，花费时间较多，时间复杂为 o^3
     *
     * @param a
     */
    public static void shellSort(int[] a) {
        int temp = 0;
        // 排序分组 每次减少半最后一次不需要判断
        for (int group = a.length / 2; group > 0; group = group / 2) {
            // 按照分组计算for循环比较次数 比如第一次分为5组 第二次分为2组
            for (int i = group; i < a.length; i++) {
                for (int j = group; j < a.length; j++) {
                    // 如果后面数比前面数小就发送交换
                    // j -group 的意思是 比如 下标为0，5，的对应为1组 下标为1，6，的对应为1组
                    if (a[j - group] > a[j]) {
                        temp = a[j - group];
                        a[j - group] = a[j];
                        a[j] = temp;
                    }
                }
            }

        }
        // System.out.println(Arrays.toString(a));
    }

    public static void testTime() {
        int[] ints = new int[80000];
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * ints.length);
        }
        shellSort(ints);
        long l2 = System.currentTimeMillis();
        System.out.println("shell sort time:" + (l2 - l1) + "ms");
    }
}
