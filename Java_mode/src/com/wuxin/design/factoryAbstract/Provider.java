package com.wuxin.design.factoryAbstract;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/21:47
 * @Description: 抽象工厂类接口
 */
public interface Provider {

    /**
     * 返回Sender接口
     */
    Sender produce();
}
