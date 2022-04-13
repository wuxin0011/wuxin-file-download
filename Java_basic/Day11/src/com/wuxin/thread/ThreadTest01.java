package com.wuxin.thread;

/**
 * @Author: wuxin001
 * @Date: 2022/04/10/22:25
 * @Description: 线程
 */
public class ThreadTest01 {

    public static void main(String[] args) {

        Shop shop = new Shop();
        shop.start();

        // Thread thread = new Thread(shop);
        // thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程----------------->" + i);
        }

    }
}

class Shop extends Thread {

    @Override
    public void run() {
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println("===================>"+this.getClass().getSimpleName() + "购物了" + i + "次");
        }
        long l2 = System.currentTimeMillis();
        System.out.println("本次购物花费时间" + (l2 - l1) + "ms");

    }

    @Override
    public synchronized void start() {
        super.start();
    }
}
