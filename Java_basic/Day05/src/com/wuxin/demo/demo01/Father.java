package com.wuxin.demo.demo01;

import com.sun.javafx.scene.traversal.Hueristic2D;

/**
 * @Author: wuxin001
 * @Date: 2022/04/04/14:33
 * @Description:
 */
public class Father {
    private Integer userid;

   public Father() {
        System.out.println("father 无参构造方法");
    }

    public Father(Integer userid) {
        System.out.println("father 有参数参数构造方法");
        this.userid = userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void hello(){
        System.out.println("hello father");
    }

    public void father() {
        System.out.println("hello  father() ");
    }
}
