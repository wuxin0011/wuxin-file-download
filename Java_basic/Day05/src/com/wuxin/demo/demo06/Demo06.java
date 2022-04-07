package com.wuxin.demo.demo06;

/**
 * @Author: wuxin001
 * @Date: 2022/03/24/23:33
 * @Description:
 */
public class Demo06 {
    public static void main(String[] args) {
        VIP admin = new VIP("admin");
        admin.vip();
    }
}

class Customer {
    String name;

    public Customer() {

    }

    public Customer(String name) {
        this.name = name;
    }
}

class VIP extends Customer {
    public VIP(String name) {
        super(name);
    }
    void vip(){
        System.out.println(name + "是VIP客户");
        System.out.println(super.name + "是VIP客户");
        System.out.println(this.name + "是VIP客户");
    }
}
