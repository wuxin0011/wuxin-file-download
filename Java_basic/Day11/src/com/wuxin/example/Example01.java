package com.wuxin.example;

import com.wuxin.bean.People;
import com.wuxin.bean.Ticket;

/**
 * @Author: wuxin001
 * @Date: 2022/04/12/22:58
 * @Description: 购买火车票，100个人 10张票
 */
public class Example01 {

    public static void main(String[] args) throws InterruptedException {

        Ticket ticket = new Ticket(10, "北京-上海");
        for (int i = 0; i < 100; i++) {

            People people = new People(ticket, "user" + i, 1);
            Thread thread = new Thread(people);
            // 启动线程
            thread.start();
        }
    }

}


// 火车票

