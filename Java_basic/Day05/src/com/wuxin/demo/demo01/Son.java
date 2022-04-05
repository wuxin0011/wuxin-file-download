package com.wuxin.demo.demo01;

/**
 * @Author: wuxin001
 * @Date: 2022/04/04/14:33
 * @Description:
 */
public class Son extends Father {

    private Integer userid;

    public Son() {
        // super(); // 如果不指定father构造参数默认调用无参构造，写不写都会被调用，如果指定了构造类型，执行指定构造类型
        System.out.println("son 无参数构造方法");
    }

    public Son(Integer userid) {
        // super(userid); // 如果不指定father构造参数默认调用无参构造
        System.out.println("son 有参数构造方法");
        this.userid = userid;
    }

    @Override
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    @Override
    public Integer getUserid() {
        return this.userid;
    }

    @Override
    public void hello() {
        System.out.println("hello son ");
    }


    public void son() {
        System.out.println("hello  son() ");
    }


}
