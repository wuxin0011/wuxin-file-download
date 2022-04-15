package com.wuxin.list.source;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/8:31
 * @Description: 实现 list
 */
public class Link extends MyAbstractList {

    Node header = null;

    /**
     * 默认空节点 由于arrayList 底层实现是数组
     */
    private static final Object[] DEFAULT_OBJECT = {};


    /**
     * 默认节点内容
     */
    private static final int DEFAULT_SIZE = 10;


    /**
     * 添加节点内容
     *
     * @param data 添加节点内容
     */
    public void add(Object data) {
    }

    /**
     * 移除节点内容
     *
     * @param index 节点索引
     */
    @Override
    public void remove(int index) {

    }

    /**
     * 修改对应节点内容
     *
     * @param index   节点索引
     * @param newData 新内容
     */
    public void setNode(int index, Object newData) {

    }


    /**
     * 判断内容是否存在于该节点内容中
     *
     * @return true 表示内容存在
     */
    public boolean contains(Object o) {

        return false;
    }


    /**
     * 实现list toString()
     * ArrayList 的toString() 是 抽象类 AbstractCollection 实现的
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Link{" +
                "header=" + header +
                '}';
    }
}
