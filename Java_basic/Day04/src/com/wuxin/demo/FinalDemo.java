package com.wuxin.demo;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @Author: wuxin001
 * @Date: 2022/3/24/21:40
 * @Description: final 修饰的只能赋值一次
 */
public class FinalDemo {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.hashCode());

        a = new A();
        System.out.println(a.hashCode());

        final A a1 = new A();
        System.out.println(a.hashCode());
        System.out.println(a.equals(a1));

        // final 修饰的变量只能赋值一次再次赋值会报错
        // a1 = new A(); // java: 无法为最终变量a1分配值


    }
}

class A {
    public final static Integer INTEGER = 1;
    public Integer a = 1;

    public void setInteger(Integer a) {
        this.a = a;
    }
}

class B extends A {

}

// java.lang.String 的String 无法被被继承 原因是 添加了final修饰词
// class StringDemo extends java.lang.String
// 一下一些基本类型对象都是无法被继承的
// class LongDemo extends java.lang.Long
// class DoubleDemo extends java.lang.Double
// class BooleanDemo extends java.lang.Boolean
// class DoubleDemo extends java.lang.Double
// class Demo extends java.lang.Byte
// class Demo extends java.lang.Float
// class Demo extends java.lang.Short
// class Demo extends java.lang.Character
// ...
