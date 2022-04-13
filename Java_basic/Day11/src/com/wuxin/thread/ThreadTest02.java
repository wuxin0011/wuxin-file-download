package com.wuxin.thread;

/**
 * @Author: wuxin001
 * @Date: 2022/04/10/23:00
 * @Description: 实现多线程方式二 实现runable接口
 */
public class ThreadTest02 {

    public static void main(String[] args) {

        Thread thread = new Thread(new Person());
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程-------------->" + i);
        }
    }
}

class Person implements Runnable {
    @Override
    public void run() {
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程-------------->" + i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("分支时间=========>"+(l2-l1)+"ms");
    }
}


