package com.wuxin.linkedlist;

import com.wuxin.linkedlist.bean.LinkedNode;
import com.wuxin.linkedlist.bean.SingleLinkedList;

/**
 * @Author: wuxin001
 * @Date: 2022/04/18/16:04
 * @Description:
 */
public class DemoTest01 {
    public static void main(String[] args) {

        LinkedNode l1 = new LinkedNode(1, "张三");
        LinkedNode l2 = new LinkedNode(2, "李四");
        LinkedNode l3 = new LinkedNode(3, "王五");
        LinkedNode l4 = new LinkedNode(4, "李六");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(l1);
        singleLinkedList.addNode(l2);
        singleLinkedList.addNode(l3);
        singleLinkedList.addNode(l4);

        singleLinkedList.list();
    }
}
