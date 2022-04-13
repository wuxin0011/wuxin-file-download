package com.wuxin.deadThread;

/**
 * @Author: wuxin001
 * @Date: 2022/04/12/22:33
 * @Description: 死锁
 */
public class DeadThread01 {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        User1 user1 = new User1(o1, o2);
        User2 user2 = new User2(o1, o2);

        user1.start();
        user2.start();
    }


}

class User1 extends Thread {
    private Object o1;
    private Object o2;

    public User1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println(o2);
            }
        }
    }



}
class User2 extends Thread {
    private Object o1;
    private Object o2;

    public User2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println(o1);
            }
        }
    }


}