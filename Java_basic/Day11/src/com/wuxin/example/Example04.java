package com.wuxin.example;

import com.sun.corba.se.impl.orbutil.threadpool.ThreadPoolImpl;
import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import com.wuxin.bean.People;
import com.wuxin.bean.Ticket;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/7:33
 * @Description: 线程池
 */
public class Example04 {

    public static void main(String[] args) {

        Ticket ticket = new Ticket(50, "北京-上海");

        int sum = 0;
        Thread[] threads = new Thread[100];
        ThreadGroup threadGroup = new ThreadGroup("default-thread-group-01");
        ThreadPool threadPool = new ThreadPoolImpl(threadGroup,"default-name-01");

        for (int i = 0; i < 100; i++) {

            People people = new People(ticket, "user" + i, 1);
            Thread thread = new Thread(people);

        }


    }
}
