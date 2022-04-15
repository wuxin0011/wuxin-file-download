package com.wuxin.list.source;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/8:52
 * @Description: 实现List 一些接口
 */
public abstract class MyAbstractList implements List {


    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public boolean isContains(Object o) {
        return false;
    }

    @Override
    public void set(int index, Object newData) {

    }

    @Override
    public String toString() {
        return "MyAbstractList{}";
    }
}
