package com.wuxin.DataType;

/**
 * @Author: wuxin001
 * @Date: 2022/03/19/17:36
 * @Description:
 */
public class DataType02 {
    public static void main(String[] args) {
        System.out.println('a');
        System.out.println('a'+1);
        System.out.println('A'+0);
        System.out.println('0'+0);
        System.out.println("-----------");


        System.out.println('a'+'b');
        System.out.println("a"+"b");

        System.out.println("hello"+'a'+1);
        System.out.println('a'+1+"hello");
        System.out.println("5+5="+5+5);
        // string + int => string
        String s = "100+100=" + 100;
        System.out.println(s+100);
        System.out.println(5+5);
        System.out.println(5+5+"=5+5");
    }
}
