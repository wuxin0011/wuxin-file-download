package com.wuxin.design.bridge;

/**
 * @Author: wuxin001
 * @Date: 2022/05/16/17:27
 * @Description:
 */
public class Bridge {

    private  PhoneAction action;


    public void open() {
        action.open();
    }

    public void close() {
        action.close();
    }

    public void charge() {
        action.charge();
    }

    public PhoneAction getAction() {
        return action;
    }

    public void setPhone(PhoneAction action) {
        this.action = action;
    }


}
