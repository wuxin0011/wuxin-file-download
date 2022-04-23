package com.wuxin.demo;

/**
 * @Author: wuxin001
 * @Date: 2022/04/22/15:34
 * @Description: 计算 阶乘 计算 输入数字到1的阶乘
 */
public class Demo02 {

    public static void main(String[] args) {

        // 随后输出结果 为 3*2*1
        System.out.println(test(3));
        // 随后输出结果 为 5*4*3*2*1
        System.out.println(test(5));
    }

    public static int test(int i) {
        if (i == 1) {
            return 1;
        } else {
            return test(i - 1) * i;
        }
    }
}
