package com.wuxin.hello;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wuxin001
 * @Date: 2022/03/19/17:06
 * @Description:
 */
public class MyArrDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("place input 3 number:");
        int[] arr;
        int i = 0;
        arr = new int[3];
        System.out.println(arr);

        while (true) {
            arr[i] = scanner.nextInt();
            i++;
            if (i >= arr.length) {
                break;
            }
        }
        System.out.println("arr=>" + Arrays.toString(arr));

        for (int i1 = 0; i1 < arr.length; i1++) {
            System.out.println("arr[" + i1 + "] =" + arr[i1]);
        }

        int tmp = 0;
        for (int i1 = 1; i1 < arr.length; i1++) {
            tmp = arr[i1 - 1] > arr[i1] ? arr[i1 - 1] : arr[i1];
        }
        System.out.println(tmp);

    }
}
