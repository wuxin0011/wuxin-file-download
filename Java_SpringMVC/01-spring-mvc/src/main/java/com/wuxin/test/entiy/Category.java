package com.wuxin.test.entiy;

/**
 * @author: wuxin001
 * @date: 2022/7/20 11:07
 * @Description:
 */

public class Category {

    private int cid;
    private String name;

    public Category(int cid, String name) {
        this.cid = cid;
        this.name = name;
    }

    public Category() {
    }

    public int getcid() {
        return cid;
    }

    public void setcid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }
}
