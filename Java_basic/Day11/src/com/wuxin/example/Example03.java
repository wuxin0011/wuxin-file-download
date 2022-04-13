package com.wuxin.example;

import com.wuxin.bean.People;
import com.wuxin.bean.Ticket;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/7:14
 * @Description:
 */
public class Example03 {

    public static void main(String[] args) throws InterruptedException {

        Ticket ticket = new Ticket(50, "北京-上海");

        int sum = 0;
        ThreadGroup threadGroup = new ThreadGroup("ticket1");
        // threadGroup.enumerate()
        threadGroup.setMaxPriority(100);
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {

            People people = new People(ticket, "user" + i, 1);
            Thread thread = new Thread(people);
            // 启动线程
            // thread.start();
            threads[i] = thread;
            threadGroup.enumerate(threads);
            // Thread.sleep(2000);
            // threadGroup.add(new Thread(people));
        }
        int maxPriority = threadGroup.getMaxPriority();
        System.out.println(maxPriority);

    }
}
