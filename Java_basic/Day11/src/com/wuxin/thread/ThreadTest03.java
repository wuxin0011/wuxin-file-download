package com.wuxin.thread;

/**
 * @Author: wuxin001
 * @Date: 2022/04/11/0:45
 * @Description: 匿名内部类实现多线程
 */
public class ThreadTest03 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("分支线程==========>" + i);
                }
            }
        });

        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程==========>" + i);
        }
    }
}
