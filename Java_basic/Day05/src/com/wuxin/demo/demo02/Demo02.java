package com.wuxin.demo.demo02;

import com.wuxin.demo.demo01.Father;
import com.wuxin.demo.demo01.Son;

/**
 * @Author: wuxin001
 * @Date: 2022/03/24/14:50
 * @Description: 上转型
 */
public class Demo02 {
    public static void main(String[] args) {
        Son son = new Son();
        Father father = (Father) son;
        father.hello(); // hello son
    }
}
