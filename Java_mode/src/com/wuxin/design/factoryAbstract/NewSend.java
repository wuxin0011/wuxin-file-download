package com.wuxin.design.factoryAbstract;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/2:04
 * @Description:
 */
public class NewSend implements Sender{

    @Override
    public void Send() {
        System.out.println("new mail faction");
    }
}
