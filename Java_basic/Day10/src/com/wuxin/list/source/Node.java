package com.wuxin.list.source;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/8:28
 * @Description: 模拟ArrayList节点内容  data + 下一个节点内存地址
 */
public class Node {
    // 存储内容
    private Object data;
    // 下一个单元的内存地址
    private Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
    }

    public Object getO() {
        return data;
    }

    public void setO(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
