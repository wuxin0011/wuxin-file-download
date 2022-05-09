package com.wuxin.binaryTree;

/**
 * @Author: wuxin001
 * @Date: 2022/04/28/10:39
 * @Description:
 */
public class BinaryTree {
    /**
     * 根节点
     */
    public HeroNode root;


    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("空节点！");
        }

    }


    public HeroNode preOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.root != null) {
            heroNode = this.root.preOrderSearch(no);
        } else {
            System.out.println("节点未找到！");
        }
        return heroNode;
    }

    // 中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        }else {
            System.out.println("空节点！");
        }
    }

    public HeroNode midOeOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.root != null) {
            heroNode = this.root.midOrderSearch(no);
        } else {
            System.out.println("节点未找到！");
        }
        return heroNode;
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("空节点！");
        }
    }

    public HeroNode postOeOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.root != null) {
            heroNode = this.root.postOrderSearch(no);
        } else {
            System.out.println("节点未找到！");
        }
        return heroNode;
    }

    public void delNode(int no) {
        if (this.root != null) {
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                this.root.delNode(no);
            }
        } else {
            System.out.println("root节点为null");
        }

    }
}
