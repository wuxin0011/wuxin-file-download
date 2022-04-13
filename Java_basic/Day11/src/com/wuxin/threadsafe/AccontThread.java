package com.wuxin.threadsafe;

/**
 * @Author: wuxin001
 * @Date: 2022/04/12/17:14
 * @Description:
 */
public class AccontThread implements Runnable {
    private Account account;
    private int money;
    private String username;

    public AccontThread(String username, Account account, int money) {
        this.account = account;
        this.username = username;
        this.money = money;
    }

    // public void doSome(int money) throws Exception {
    //     synchronized (this) {
    //         int n = this.account.getMoney() - money;
    //         if (n > 0) {
    //             //     剩余多少钱
    //             this.account.setMoney(n);
    //             System.out.println(this.username + "取出" + money + ",账户" + this.account.getName() + "剩余" + this.account.getMoney());
    //             return;
    //         }
    //         throw new Exception("对不起，您的余额不足！");
    //     }
    // }

    public synchronized void doSome(int money) throws Exception {
        int n = this.account.getMoney() - money;
        if (n > 0) {
            //     剩余多少钱
            this.account.setMoney(n);
            System.out.println(this.username + "取出" + money + ",账户" + this.account.getName() + "剩余" + this.account.getMoney());
            return;
        }
        throw new Exception("对不起，您的余额不足！");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            this.doSome(this.money);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
