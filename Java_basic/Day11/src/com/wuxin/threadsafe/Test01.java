package com.wuxin.threadsafe;

/**
 * @Author: wuxin001
 * @Date: 2022/04/12/17:20
 * @Description:
 */
public class Test01 {

    public static void main(String[] args) {

        Account account = new Account(10000, "wuxin001");

        AccontThread a1 = new AccontThread("user1",account,3000);
        AccontThread a2 = new AccontThread("user2",account,3000);

        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a2);


        t1.start();
        t2.start();
    }
}
