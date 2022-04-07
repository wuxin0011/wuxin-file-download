package com.wuxin.demo.demo08;

/**
 * @Author: wuxin001
 * @Date: 2022/03/24/23:35
 * @Description:
 */
public class Demo08 {
    public static void main(String[] args) {
        System.out.println("========执行有参数构造方法=========");
        VIP admin = new VIP("admin");
        admin.vip();
        //
        // System.out.println("========执行无参数构造方法=========");
        // VIP vip = new VIP();
    }
}

class Customer {
    String name;

    public Customer() {
        System.out.println("Customer  无参构造方法执行");
    }

    public Customer(String name) {
        System.out.println("Customer 有参构造方法执行");
        this.name = name;
        System.out.println("Customer super = " + this);
        System.out.println("Customer Object hashCode = " + super.hashCode());
        System.out.println("Customer hashCode = " + this.hashCode());
    }

    void hello() {
        System.out.println("Customer hello()");
    }
}

class VIP extends Customer {
    String name;

    public VIP() {
        // 默认内容
        // super(null);
        // this.name = null
        System.out.println("VIP 无参构造方法执行");
    }

    public VIP(String name) {
        super(name);
        System.out.println("VIP this = " + this);
        System.out.println("VIP father hashCode = " + super.hashCode());
        System.out.println("VIP hashCode = " + this.hashCode());
        // 默认内容
        // this.name = null
    }

    void vip() {
        System.out.println(name + "是VIP客户"); // null
        System.out.println(super.name + "是VIP客户");  // admin
        System.out.println(this.name + "是VIP客户");  // null
        // 访问父类方法
        super.hello();
    }
}
