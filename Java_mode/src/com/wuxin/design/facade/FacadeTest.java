package com.wuxin.design.facade;

/**
 * @Author: wuxin001
 * @Description: 外观模式测试
 */
public class FacadeTest {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.close();
    }
}
