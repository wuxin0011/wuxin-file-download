package com.wuxin;

import java.util.Arrays;

/**
 * 快速排序 选择一个基准数 找到基准数左边最大数和最小数，交换位置，以此类推
 * <p>
 * 简单来说 就是一个向左递归，一个向向右递归
 *
 * @Author: wuxin001
 * @Date: 2022/04/22/17:18
 * @Description: 快速排序 快速排序是对冒泡排序的一种改进方式
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 79, 10, 33, 44, 222, 5, 44};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        testTime();
    }

    public static void quickSort(int[] arr, int left, int right) {
        int r = right;
        int l = left;
        // 基准数
        int pivot = arr[(right + left) / 2];
        // 循环的，目的是找到基准数小的在左边，大的在右边
        while (l < r) {
            // 从左往右
            // 在pivot左边找，找到大于或等于 pivot的数
            while (arr[l] < pivot) {
                l++;
            }
            // 从右往左
            // 在pivot右边边找，找到小于或者等于 pivot的数
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            // 位置交换 右边 比 pivot的数和左边比pivot打的数交换
            int temp;
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 如果交换完毕之后，发现arr[l]==pivot
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }

        }

        if (l == r) {

            l++;

            r--;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void testTime() {
        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * ints.length);
        }
        long l1 = System.currentTimeMillis();
        quickSort(ints, 0, ints.length - 1);
        long l2 = System.currentTimeMillis();
        System.out.println("quick sort:" + (l2 - l1) + "ms");
    }
}
