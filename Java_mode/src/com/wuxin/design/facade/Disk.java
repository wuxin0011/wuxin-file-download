package com.wuxin.design.facade;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:31
 * @Description:
 */
public class Disk implements StartClose{

    @Override
    public void startup() {
        System.out.println("磁盘开启了...");
    }

    @Override
    public void close() {
        System.out.println("磁盘关闭了 ...");
    }
}
