package com.wuxin.linkedlist;

import com.wuxin.linkedlist.bean.LinkedNode;
import com.wuxin.linkedlist.bean.SingleLinkedList;

/**
 * @Author: wuxin001
 * @Date: 2022/04/18/16:04
 * @Description: 如果顺序打乱 要求输出结果还是按照顺序输出
 */
public class DemoTest02 {
    public static void main(String[] args) {

        LinkedNode l1 = new LinkedNode(3, "王五");
        LinkedNode l2 = new LinkedNode(1, "张三");
        LinkedNode l3 = new LinkedNode(4, "李六");
        LinkedNode l4 = new LinkedNode(2, "李四");

        // 添加节点 按照id大小顺序添加节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addOrderById(l1);
        singleLinkedList.addOrderById(l2);
        singleLinkedList.addOrderById(l3);
        singleLinkedList.addOrderById(l4);
        System.out.println("================按照顺序添加id输出==============");
        singleLinkedList.list();

        // 修改节点
        System.out.println("================update==============");
        LinkedNode updateNode1 = new LinkedNode( 1,"小和");
        LinkedNode updateNode2 = new LinkedNode( 2,"小2");
        singleLinkedList.update(updateNode1);
        singleLinkedList.update(updateNode2);
        singleLinkedList.list();

        // 删除节点
        System.out.println("================remove==============");
        singleLinkedList.remove(1);
        singleLinkedList.remove(4);
        singleLinkedList.list();
    }
}
