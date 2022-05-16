package com.wuxin.design.composite;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:47
 * @Description:
 */
public class CompositeTest {

    public static void main(String[] args) {
        Tree tree = new Tree(new TreeNode("A"));
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");

        b.add(c);
        c.add(d);
        // 根节点
        tree.root.add(b);


        System.out.println(tree.root.getChildren());
    }
}
