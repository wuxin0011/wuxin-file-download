package com.wuxin.hello;

/**
 * @Author: wuxin001
 * @Date: 2022/03/19/16:56
 * @Description:
 */
public class Arr2Sum {

    public static void main(String[] args) {
        int[][] arr = {{100,100,100},{100,100,100},{100,100,100}};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
