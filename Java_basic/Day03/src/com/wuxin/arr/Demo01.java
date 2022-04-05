package com.wuxin.arr;

import java.util.Arrays;

/**
 * -> 1
 * -> 1  2
 * -> 1 2 3
 *
 * @Author: wuxin001
 * @Date: 2022/03/22/22:45
 * @Description: 动态添加二位数组
 */
public class Demo01 {

    public static void main(String[] args) {
        int[][] ints = new int[8][];

        for (int i = 0; i < ints.length; i++) {
            // 给一维数组开辟空间
            ints[i] = new int[i + 1];

            // 遍历二维数组
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = j;
            }
        }

        System.out.println(Arrays.deepToString(ints));
    }
}
