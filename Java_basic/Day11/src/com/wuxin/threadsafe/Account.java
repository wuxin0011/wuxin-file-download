package com.wuxin.threadsafe;

/**
 * @Author: wuxin001
 * @Date: 2022/04/12/16:08
 * @Description: 线程安全 最终要一条，效率不是最终要，不能因为开启多线程，而放弃数据安全
 */
public class Account  {

    /**
     * 账户多少钱
     */
    private int money;

    /**
     * 账户名称
     */
    private String name;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account() {
    }

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    /**
     * 借了多少钱
     * @param m 借钱数
     * @return 剩余多少钱
     */
    public int surplus(int m) throws Exception {
       if(this.money - m > 0){
           setMoney(this.money-m);
           return this.money;
       }
       throw new Exception("对不起，您的不足"+m+"元");
    }


}
