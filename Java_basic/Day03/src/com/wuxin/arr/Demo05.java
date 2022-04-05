package com.wuxin.arr;

/**
 * @Author: wuxin001
 * @Date: 2022/03/22/23:56
 * @Description: 实现Array.toString 方法
 */
public class Demo05 {

    public static void main(String[] args) {
        int[] ints = {1, 100, 200, 99};

        System.out.println(arrToString(ints));
    }

    public static String arrToString(int[] arr) {
        // 空对象
        if (arr == null) {
            return "null";
        }
        int maxLength = arr.length;

        // 空数组
        if (maxLength == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < maxLength; i++) {
            stringBuilder.append(arr[i]);
            stringBuilder.append(",");
            // 最后一行
            if (i == maxLength - 1) {
                stringBuilder.append(arr[i - 1]);
                stringBuilder.append("]");
            }
        }

        return stringBuilder.toString();
    }

    public static String arrToString(Object[] arr) {
        // 空对象
        if (arr == null) {
            return "null";
        }
        int maxLength = arr.length;

        // 空数组
        if (maxLength == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < maxLength; i++) {
            stringBuilder.append(arr[i]);
            stringBuilder.append(",");
            // 最后一行
            if (i == maxLength - 1) {
                stringBuilder.append(arr[i - 1]);
                stringBuilder.append("]");
            }
        }

        return stringBuilder.toString();
    }

    // ... 下面等都是方法重载，写入不同类型就可以了
}
