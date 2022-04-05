package com.wuxin.scanner;

import java.util.Scanner;

/**
 * @Author: wuxin001
 * @Date: 2022/03/20/13:31
 * @Description:
 */
public class Demo03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个数组标识星期几");
        String next = scanner.next();
        System.out.println("您输入的内容是:"+next);
        try {
            int i = Integer.parseInt(next);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("请输入数字！");
        }
    }
}
