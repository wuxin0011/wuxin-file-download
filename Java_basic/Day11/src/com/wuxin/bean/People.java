package com.wuxin.bean;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/6:59
 * @Description:
 */
public
class People implements Runnable {
    /**
     * 火车票
     */
    private Ticket ticket;

    /**
     * 用户名
     */
    private String name;


    /**
     * 想购买 火车票数量
     */
    private int count;


    /**
     * 实际上购买到火车票数量
     */
    private int realCount;


    public People(Ticket ticket, String name, int count) {
        this.ticket = ticket;
        this.name = name;
        this.count = count;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRealCount() {
        return realCount;
    }

    public void setRealCount(int realCount) {
        this.realCount = realCount;
    }

    // Example01
    // public void shopTicket() throws Exception {
    //     // 购买火车票方法 判断火车票数量是否大于0
    //     int ticketCount = this.ticket.getCount();
    //     if (ticketCount > 0 && ticketCount - this.count >= 0) {
    //         // 如果符合要求，该用户能够购买到火车票
    //         setRealCount(this.count);
    //         // 火车票数量建减少
    //         this.ticket.setCount(ticketCount - this.count);
    //         // 重写了toString方法，输出用户信息
    //         System.out.println(this);
    //         return;
    //     }
    //     throw new Exception("对不起[" + this.getName() + "]您没抢到火车票！");
    // }


    // Example02
    public void shopTicket() throws Exception {
        // 锁住对象 等该对象锁释放才会执行下一步操作
        synchronized (ticket) {
            // 购买火车票方法 判断火车票数量是否大于0
            int ticketCount = ticket.getCount();
            if (ticketCount > 0 && ticketCount - count >= 0) {
                // 如果符合要求，该用户能够购买到火车票
                setRealCount(count);
                // 火车票数量建减少
                this.ticket.setCount(ticketCount -count);
                // 重写了toString方法，输出用户信息
                System.out.println(this);
                return;
            }
            throw new Exception("对不起[" + this.getName() + "]您没抢到火车票！");
        }

    }

    @Override
    public void run() {
        try {
            // 模拟网络延迟 ，出现多并发情况
            Thread.sleep(10000);
            this.shopTicket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.getName() + "购买到火车票" + this.getRealCount();
    }
}