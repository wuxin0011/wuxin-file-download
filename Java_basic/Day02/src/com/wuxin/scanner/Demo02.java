package com.wuxin.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author: wuxin001
 * @Date: 2022/03/20/9:55
 * @Description:
 */
public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.println("请输入一个整数:=>");
        int total = 0;
        int[] ints = new int[5];
        System.out.println(ints.length);
        int i;
        try {
            i = scanner.nextInt();
        } catch (Exception e) {
            // e.printStackTrace();
            new InputMismatchException("输入结果错误，请输入正确的结果！");
        }
        // while (total < ints.length) {
        //     try {
        //         ints[total] = i;
        //         total ++;
        //     } catch (Exception e) {
        //         // new Exception("输入错误，请重新输入！");
        //         System.out.println(e.getMessage());
        //         continue;
        //     }
        // }
        // for (int i1 = 0; i1 < ints.length; i1++) {
        //     System.out.println("ints["+i1+"]="+ints[i1]);
        // }

    }
}
