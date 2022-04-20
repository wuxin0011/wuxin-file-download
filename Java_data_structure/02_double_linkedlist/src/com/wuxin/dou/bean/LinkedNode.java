package com.wuxin.linkedlist.bean;

/**
 * @Author: wuxin001
 * @Date: 2022/04/18/15:59
 * @Description: 链表内存节点单元
 */
public class LinkedNode {

    public int id;
    public String name;
    public LinkedNode nextNode;

    public LinkedNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
