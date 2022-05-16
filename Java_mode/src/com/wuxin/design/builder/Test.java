package com.wuxin.design.builder;

/**
 * @Author: wuxin001
 * @Date: 2022/05/10/10:17
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        // 使用房子建造类实现内部方法调用
        HouseBuilder houseBuilder = new HouseBuilder(new HouseA());
        houseBuilder.builder();

        HouseBuilder houseBuilder1 = new HouseBuilder(new HouseB());
        houseBuilder1.builder();

        // 使用建造者模式案例
        test();
    }

    public static void test() {
        StringBuilder hello_world = new StringBuilder("hello world");
        System.out.println(hello_world);
    }
}
