package com.wuxin.demo;

import com.wuxin.demo.demo01.Son;

/**
 * @Author: wuxin001
 * @Date: 2022/03/24/22:56
 * @Description: 继承
 */
public class ExtendDemo01 {
    public static void main(String[] args) {
        Son son = new Son(100);
        System.out.println(son.getUserid());
    }
}
