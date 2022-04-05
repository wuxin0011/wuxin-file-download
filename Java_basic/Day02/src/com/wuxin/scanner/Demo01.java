package com.wuxin.scanner;

import java.util.Scanner;

/**
 * @Author: wuxin001
 * @Date: 2022/03/20/9:53
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input =========>");
        String next = scanner.next();
        System.out.println("您输入数值是=>"+next);
    }
}
