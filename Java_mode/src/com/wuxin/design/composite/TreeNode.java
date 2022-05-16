package com.wuxin.design.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:41
 * @Description: 组合模式  节点测试
 */
public class TreeNode {
    private String name;
    private TreeNode parentNode;
    private Vector<TreeNode> childrenNode = new Vector<TreeNode>();

    public TreeNode(String name) {
        this.name = name;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }


    /**
     * 添加子节点
     * @param node node
     */
    public void add(TreeNode node) {
        childrenNode.add(node);
    }

    /**
     * 删除子节点
     * @param node node
     */
    public void remove(TreeNode node) {
        childrenNode.remove(node);
    }

    /**
     * 获取子节点
     * @return 子节点
     */
    public Enumeration<TreeNode> getChildren(){
        return childrenNode.elements();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "name='" + name + '\'' +
                '}';
    }
}
