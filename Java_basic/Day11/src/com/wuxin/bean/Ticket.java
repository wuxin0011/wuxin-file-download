package com.wuxin.bean;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/6:59
 * @Description:
 */
public class Ticket {
    /**
     * 火车票数量
     */
    private int count;

    /**
     * 火车票地点
     */
    private String name;

    public Ticket(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
