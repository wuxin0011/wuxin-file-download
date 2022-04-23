package com.wuxin;

import java.util.Arrays;

/**
 * 什么是选择排序？
 *
 * @Author: wuxin001
 * @Date: 2022/04/22/17:17
 * @Description: 排序 冒泡排序
 */
public class Demo02 {
    public static void main(String[] args) {

        // int[] ints = {2, 7, 11, 15};
        // System.out.println(Arrays.toString(twoSum(ints, 26)));
        // System.out.println(Arrays.toString(twoSum2(ints, 26)));

        // int[] ints1 = {2, -7, 100, 99, 20, 121, -125, 1, 3, 4, 5};
        // bubbleSort(ints1);

        testTime();
        Demo01.testTime();
    }

    /**
     * 冒泡排序实现
     *
     * @param ints ints
     */
    public static void bubbleSort(int[] ints) {
        long l1 = System.currentTimeMillis();
        System.out.println("冒泡排序");
        // System.out.println("初始" + Arrays.toString(ints));
        int temp;
        for (int j = 0; j < ints.length - 1; j++) {
            for (int i = 0; i < ints.length - 1 - j; i++) {
                if (ints[i] > ints[i + 1]) {
                    temp = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = temp;
                }

            }
            // System.out.println("第" + (j + 1) + "排序" + Arrays.toString(ints));
        }
        long l2 = System.currentTimeMillis();
        System.out.println("耗时:" + (l2 - l1) + "ms");


    }

    /**
     * 计算两个数之和 来源 leetcode 两个数之和
     *
     * @param nums   nums
     * @param target 值
     * @return 输出两个数之和=target的索引
     */
    public static int[] twoSum(int[] nums, int target) {
        // 初始化两个数组下表容器
        int[] newInt = new int[2];
        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = nums.length - 1; i2 > i1; i2--) {
                int sum = nums[i1] + nums[i2];
                if (target == sum) {
                    newInt[0] = i1;
                    newInt[1] = i2;
                    return newInt;
                }
            }
        }
        return null;
    }


    /**
     * 计算两个数之和
     *
     * @param nums   nums
     * @param target 值
     * @return 输出两个数之和=target的索引
     */
    public static int[] twoSum2(int[] nums, int target) {
        // 初始化两个数组下表容器
        int[] newInt = new int[2];
        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                int sum = nums[i1] + nums[i2];
                if (target == sum) {
                    newInt[0] = i1;
                    newInt[1] = i2;
                    return newInt;
                }
            }
        }
        return null;
    }

    public static void testTime() {
        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * ints.length);
        }
        bubbleSort(ints);
    }


}
