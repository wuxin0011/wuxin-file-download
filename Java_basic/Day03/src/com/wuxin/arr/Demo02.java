package com.wuxin.arr;

import java.util.Arrays;

/**
 * @Author: wuxin001
 * @Date: 2022/03/22/23:05
 * @Description: 杨辉三角
 */
public class Demo02 {

    public static void main(String[] args) {
        int[][] ints = new int[10][];
        for (int i = 0; i < ints.length; i++) {

            ints[i] = new int[i + 1];
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                // 排除第一列和最后列
                if (i1 == 0 || i1 == ints[i].length - 1) {
                    ints[i][i1] = 1;
                } else {
                    ints[i][i1] = ints[i - 1][i1] + ints[i - 1][i1 - 1];
                }

            }



        }

        // 输出结果
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                System.out.print(ints[i][i1] + "\t");
            }
            // 每输入一组换行
            System.out.println();
        }

        // System.out.println(Arrays.deepToString(ints));
    }
}
