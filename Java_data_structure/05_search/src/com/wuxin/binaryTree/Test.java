package com.wuxin.binaryTree;

/**
 * @Author: wuxin001
 * @Date: 2022/05/02/9:59
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        HeroNode heroNode1 = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义");
        HeroNode heroNode3 = new HeroNode(3, "吴用");
        HeroNode heroNode4 = new HeroNode(4, "公孙胜");
        HeroNode heroNode5 = new HeroNode(5, "关胜");
        HeroNode heroNode6 = new HeroNode(6, "林冲");
        HeroNode heroNode7 = new HeroNode(7, "秦明");

        // 设置root节点的左右节点
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);

        // 设置第二个节点的左右
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);

        // 设置第三个节点的左右
        heroNode3.setLeft(heroNode6);
        heroNode3.setRight(heroNode7);

        // 设置root节点
        BinaryTree binaryTree = new BinaryTree(heroNode1);

        System.out.println("===========前序遍历============");
        binaryTree.preOrder();
        System.out.println("===========中序遍历============");
        binaryTree.midOrder();
        System.out.println("===========后序遍历============");
        binaryTree.postOrder();

        System.out.println("===========前序查找============");
        System.out.println(binaryTree.preOrderSearch(5));
        System.out.println("===========中序查找============");
        System.out.println(binaryTree.preOrderSearch(3));
        System.out.println("===========后序查找============");
        System.out.println(binaryTree.preOrderSearch(4));
        System.out.println(binaryTree.preOrderSearch(10));

        System.out.println("===========节点删除============");
        System.out.println("节点删除之前");
        binaryTree.preOrder();
        binaryTree.delNode(1);
        System.out.println("节点删除之后");
        binaryTree.preOrder();
    }
}
