package com.wuxin.dou;

import com.wuxin.dou.bean.LinkedNode;
import com.wuxin.dou.bean.SingleLinkedList;

/**
 * @Author: wuxin001
 * @Date: 2022/04/19/8:53
 * @Description:
 */
public class Demo01 {

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

        System.out.println("测试删除节点");
        singleLinkedList.remove(1);
        singleLinkedList.remove(4);
        singleLinkedList.list();
    }
}
