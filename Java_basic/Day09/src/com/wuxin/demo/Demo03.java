package com.wuxin.demo;

/**
 * @Author: wuxin001
 * @Date: 2022/04/06/19:44
 * @Description: 接口 接口和抽象类最大区别就是接口中不能有具体实现方法 抽象类中可以有实现方法
 * 1、接口方法默认全部是可以访问的 即 public
 * 2、接口可以看做是抽象类中特殊抽象类，所有方法完全是抽象的，继承该接口的类需要实现接口中的方法
 * 3、与抽象类不同的是，接口可以多继承，抽象类只能是单继承
 */
public class Demo03 {
    public static void main(String[] args) {
        Add add = new Add();
        int result = add.result(add, 100, 200);
        System.out.println(result);

        /**
         * 问题: 为什么 Add 类中result方法传入对象是sum接口，但是在Sum中没有实现，却能够输出结果？
         * 1、首先 是 Add 继承了 Sum 类，由于接口是完全抽象的，因此必须要实现Sum类中方法
         * 2、作为继承关系，Sum类相当于是Add类的父类，因此编译的时候，执行父类，父类Sum中有方法 add() 编译通过
         * 运行的时候，该内存地址指向的是子类 Add ,因此调用的是 Add 中的方法
         */
    }
}

interface Sum {

    /**
     * 实现 两个数相加
     *
     * @param a
     * @param b
     * @return
     */
    int add(int a, int b);
}

class Add implements Sum {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    public int result(Sum sum, int a, int b) {
        return sum.add(a, b);
    }
}


