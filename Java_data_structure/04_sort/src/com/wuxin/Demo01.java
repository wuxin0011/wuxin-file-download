package com.wuxin;

import java.util.Arrays;

/**
 * 时间频度
 *
 * @Author: wuxin001
 * @Date: 2022/04/22/17:17
 * @Description: 排序算法 选择排序
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] ints = {2, 1, 87, 9, 29, 44, 90, 23, 11, 0, -1, 100};
        sort1(ints);
        sort2(ints);
        sort3(ints);
        sort4(ints);


    }

    /**
     * 选择排序算法优化
     *
     * @param ints ints
     */
    public static void sort0(int[] ints) {


        System.out.println("处理之后:" + Arrays.toString(ints));
    }


    public static void sort1(int[] ints) {

        if (ints == null || ints.length == 0) {
            throw new RuntimeException("array is null");
        }
        long l = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            // System.out.println(ints[i]);
            for (int i1 = i + 1; i1 < ints.length; i1++) {
                if (ints[i] > ints[i1]) {
                    int temp = ints[i];
                    ints[i] = ints[i1];
                    ints[i1] = temp;
                }
            }
        }
        System.out.println("=============选择排序 小->大 实现方式一====================");
        // System.out.println("处理之后:" + Arrays.toString(ints));
        long l2 = System.currentTimeMillis();
        System.out.println("耗时:" + (l2 - l) + "ms");
    }


    public static void sort2(int[] ints) {
        if (ints == null || ints.length == 0) {
            throw new RuntimeException("array is null");
        }
        for (int i = 0; i < ints.length; i++) {
            // System.out.println(ints[i]);
            for (int i1 = ints.length - 1 - i; i1 > i; i1--) {
                if (ints[i] > ints[i1]) {
                    int temp = ints[i];
                    ints[i] = ints[i1];
                    ints[i1] = temp;
                }
            }
        }
        System.out.println("=============选择排序 小->大 实现方式二====================");
        System.out.println("处理之后:" + Arrays.toString(ints));
    }


    public static void sort3(int[] ints) {
        if (ints == null || ints.length == 0) {
            throw new RuntimeException("array is null");
        }
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = i + 1; i1 < ints.length; i1++) {
                if (ints[i] < ints[i1]) {
                    int temp = ints[i];
                    ints[i] = ints[i1];
                    ints[i1] = temp;
                }
            }
        }
        System.out.println("=============选择排序 大->小 实现方式一====================");
        System.out.println("处理之后:" + Arrays.toString(ints));
    }


    public static void sort4(int[] ints) {
        if (ints == null || ints.length == 0) {
            throw new RuntimeException("array is null");
        }
        for (int i = 0; i < ints.length; i++) {
            // System.out.println(ints[i]);
            for (int i1 = ints.length - 1 - i; i1 > i; i1--) {
                if (ints[i] < ints[i1]) {
                    int temp = ints[i];
                    ints[i] = ints[i1];
                    ints[i1] = temp;
                }
            }
        }
        System.out.println("=============选择排序 大->小 实现方式二====================");
        System.out.println("处理之后:" + Arrays.toString(ints));
    }

    public static void testTime() {
        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * ints.length);
        }
        sort1(ints);
    }


}
