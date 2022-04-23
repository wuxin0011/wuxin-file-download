package com.wuxin.dou.bean;

/**
 * @Author: wuxin001
 * @Date: 2022/04/18/15:55
 * @Description: 单链表实现
 */
public class SingleLinkedList {

    /**
     * 初始化头节点 默认指向下一个节点地址为null
     */
    private LinkedNode headNode = new LinkedNode(0, "");


    /**
     * 添加节点方法
     * 直接添加到最后一个节点
     *
     * @param newNode 节点
     */
    public void addNode(LinkedNode newNode) {
        // 添加一个辅助变量节点
        LinkedNode tempNode = headNode;
        // 判断nextNode是否为null 为null 说明是最后一个节点跳出循环
        // 如果不是 null 将当前节点后移
        while (tempNode.nextNode != null) {
            // 指向下一个节点
            tempNode = tempNode.nextNode;
        }
        // 最后一个节点指向新的节点
        tempNode.nextNode = newNode;
        newNode  = tempNode;
    }

    /**
     * 按照顺序添加节点
     *
     * @param newNode 新节点
     */
    public void addOrderById(LinkedNode newNode) {
        LinkedNode tempNode = headNode;
        boolean flag = false;
        while (true) {
            // 最后一个节点
            if (nodeIsNull(tempNode.nextNode)) {
                break;
            }
            // 在两个节点之间
            if (tempNode.nextNode.id > newNode.id) {
                break;
            }
            // 存在
            if (tempNode.nextNode.id == newNode.id) {
                flag = true;
                break;
            }
            // 节点下移动 遍历
            tempNode = tempNode.nextNode;
        }

        if (flag) {
            System.err.println("节点已经存在了~");
        } else {
            // 由于在两个节点之间插入 需要修改 原节点指向 a->b -----> a->c->b
            newNode.nextNode = tempNode.nextNode;
            tempNode.nextNode = newNode;
        }

    }

    public void remove(int id) {
        if (nodeIsNull(headNode.nextNode)) {
            System.err.println("~ linked is null ~");
            return;
        }
        LinkedNode tempNode = headNode.nextNode;
        boolean flag = false;
        while (true) {
            if (nodeIsNull(tempNode)) {
                break;
            }
            if (tempNode.id == id) {
                flag = true;
                break;
            }
            // 找不到向下移动一位 实现遍历
            tempNode = tempNode.nextNode;
        }

        if (flag) {
            // 让该节点的上一个节点的next指向该节点的下一个节点
            // 如果删除的是头节点 preNode=null
            // if(nodeIsNotNull(tempNode.preNode)){
            //
            // }
            if (nodeIsNotNull(tempNode.preNode)) {
                tempNode.preNode.nextNode = tempNode.nextNode;
            }

            // 让该节点的下一个节点的pre指向该节点的上一个节点
            // 如果删除的是尾节点 nextNode =null
            if (nodeIsNotNull(tempNode.nextNode)) {
                tempNode.nextNode.preNode = tempNode.preNode;
            }
        } else {
            System.err.println("找不到该节点哦");
        }
    }

    /**
     * 修改
     *
     * @param updateNode
     */
    public void update(LinkedNode updateNode) {
        if (nodeIsNull(headNode.nextNode)) {
            System.err.println("linkedList is null");
            return;
        }
        boolean flag = false;
        LinkedNode tempNode = headNode.nextNode;
        while (true) {
            if (nodeIsNull(tempNode)) {
                break;
            }
            if (tempNode.id == updateNode.id) {
                flag = true;
                break;
            }
            // 遍历
            tempNode = tempNode.nextNode;
        }

        if (flag) {
            tempNode.name = updateNode.name;
        } else {
            System.err.println("找不到~");
        }
    }

    /**
     * 判断节点内容是否存在
     *
     * @param content content
     * @return true
     */
    public boolean contains(Object content) {

        return false;
    }

    /**
     * 节点遍历
     */
    public void list() {
        if (headNode == null) {
            System.out.println("linkedList is null");
            return;
        }
        LinkedNode tempNode = headNode.nextNode;
        while (nodeIsNotNull(tempNode)) {
            // 输出最后一个节点
            if (nodeIsNull(tempNode.nextNode)) {
                System.out.println(tempNode);
                break;
            }
            System.out.println(tempNode);
            // 将当前节点修改为下一个节点
            tempNode = tempNode.nextNode;
        }
    }

    /**
     * 判断
     *
     * @param node
     * @return
     */
    public static boolean nodeIsNull(LinkedNode node) {
        return node == null;
    }

    /**
     * 判断
     *
     * @param node
     * @return
     */
    public static boolean nodeIsNotNull(LinkedNode node) {
        return !nodeIsNull(node);
    }


}