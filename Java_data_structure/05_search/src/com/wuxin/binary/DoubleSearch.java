package com.wuxin.brand;

import java.util.ArrayList;

/**
 * @Author: wuxin001
 * @Date: 2022/04/24/11:58
 * @Description: 二分查找
 */
public class DoubleSearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 10};

        int search = search(arr, 0, arr.length, 7);
        System.out.println(search);

        // 优化二分查找 找到所有满足条件的元素下标
        int[] arr1 = {0, 1, 1, 1, 5, 6, 7, 9, 10};
        ArrayList<Integer> integers = searchImprove(arr1, 0, arr1.length - 1, 1);
        System.out.println(integers);

    }

    /**
     * @param arr   arr
     * @param left  左边的索引
     * @param right 右边的索引
     * @param value 查找的值
     */
    public static int search(int[] arr, int left, int right, int value) {

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        // 递归退出条件
        if (left > right) {
            return -1;
        }

        if (value > midValue) {
            // 向右递归
            return search(arr, mid + 1, right, value);
        } else if (value < midValue) {
            // 向左递归
            return search(arr, left, mid - 1, value);
        } else {
            return mid;
        }

    }


    /**
     * 优化二分查找 找到所有满足条件的元素下标
     *
     * @param arr   arr
     * @param left  左边的索引
     * @param right 右边的索引
     * @param value 查找的值
     */
    public static ArrayList<Integer> searchImprove(int[] arr, int left, int right, int value) {

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        // 递归退出条件
        if (left > right) {
            return new ArrayList<>();
        }

        if (value > midValue) {
            // 向右递归
            return searchImprove(arr, mid + 1, right, value);
        } else if (value < midValue) {
            // 向左递归
            return searchImprove(arr, left, mid - 1, value);
        } else {
            ArrayList<Integer> integers = new ArrayList<>();
            // 找到了
            // 判断索引
            int tempRight = mid;
            // 默认符合条件
            integers.add(mid);
            while (tempRight > 0) {
                // 向左边查找 终止条件为 arr[index]!=value
                tempRight--;
                if (value != arr[tempRight]) {
                    break;
                }
                integers.add(tempRight);
            }

            int tempLeft = mid;

            while (tempLeft < arr.length - 1) {
                // 向右边查找 终止条件为 arr[index]!=value
                tempLeft++;
                if (value != arr[tempLeft]) {
                    break;
                }
                integers.add(tempLeft);
            }
            return integers;
        }

    }


}
