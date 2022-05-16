package com.wuxin.design.facade;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:29
 * @Description:
 */
public class CPU implements StartClose{

    @Override
    public void startup() {
        System.out.println("CUP 启动了 ...");
    }

    @Override
    public void close() {
        System.out.println("CUP 关闭了 ...");
    }
}
