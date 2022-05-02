package com.wuxin.insert;

/**
 * @Author: wuxin001
 * @Date: 2022/04/26/9:28
 * @Description: 插值查找
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] ints = new int[8000000];
        add(ints);
        // System.out.println(Arrays.toString(ints));
        int count = 0;
        System.out.println(search1(ints, 0, ints.length - 1, 2, count));
        System.out.println(search2(ints, 0, ints.length - 1, 2, count));
    }

    /**
     * 生成0-arr.length的顺序数组
     *
     * @param arr 数组
     */
    public static void add(int[] arr) {
        long l1 = System.currentTimeMillis();
        int i = 0;
        while (i < arr.length) {
            arr[i] = i;
            i++;
        }
        long l2 = System.currentTimeMillis();
        System.out.println("add time" + (l2 - l1) + "ms");
    }


    /**
     * @param arr   arr
     * @param left  左边的索引
     * @param right 右边的索引
     * @param value 查找的值
     */
    public static int search1(int[] arr, int left, int right, int value, int count) {
        System.out.println();
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        // 递归退出条件
        if (left > right) {
            return -1;
        }
        count++;

        if (value > midValue) {
            // 向右递归
            return search1(arr, mid + 1, right, value, count);
        } else if (value < midValue) {
            // 向左递归
            return search1(arr, left, mid - 1, value, count);
        } else {
            System.out.println("插值查找次数=>" + count);
            return mid;
        }

    }


    /**
     * @param arr   arr
     * @param left  左边的索引
     * @param right 右边的索引
     * @param value 查找的值
     */
    public static int search2(int[] arr, int left, int right, int value, int count) {

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        // 递归退出条件
        if (left > right) {
            return -1;
        }
        count++;

        if (value > midValue) {
            // 向右递归
            return search2(arr, mid + 1, right, value, count);
        } else if (value < midValue) {
            // 向左递归
            return search2(arr, left, mid - 1, value, count);
        } else {
            System.out.println("二分查找次数=>" + count);
            return mid;
        }

    }


}
