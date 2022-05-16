package com.wuxin.design.facade;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:31
 * @Description:
 */
public class Memory implements StartClose{

    @Override
    public void startup() {
        System.out.println("记忆工作 ... ");
    }

    @Override
    public void close() {
        System.out.println("记忆关闭 ... ");
    }
}
