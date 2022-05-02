package com.wuxin.binaryTree;

/**
 * @Author: wuxin001
 * @Date: 2022/04/28/10:33
 * @Description 二叉树节点类
 */
public class HeroNode {
    private int no;
    private String name;
    // 左节点
    private HeroNode right;
    // 右节点
    private HeroNode left;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 前序查找
     *
     * @param no 编号
     * @return HeroNode
     */
    public HeroNode preOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.no == no) {
            return this;
        }

        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
            if (resNode != null) {
                return resNode;
            }
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
            if (resNode != null) {
                return resNode;
            }
        }

        return null;
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    /**
     * 中序查找
     */
    public HeroNode midOrderSearch(int no) {
        HeroNode node = null;
        if (this.left != null) {
            node = this.left.midOrderSearch(no);
            if (node != null) {
                return node;
            }
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            node = this.right.midOrderSearch(no);
            if (node != null) {
                return node;
            }
        }
        return null;
    }

    /**
     * 后序遍历
     */
    public void postOrder() {

        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 后序查找
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode node = null;
        if (this.left != null) {
            node = this.left.preOrderSearch(no);
            if (node != null) {
                return node;
            }
        }
        if (this.right != null) {
            node = this.right.preOrderSearch(no);
            if (node != null) {
                return node;
            }
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }


}
