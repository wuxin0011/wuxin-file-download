package com.wuxin.list.source;

/**
 * @Author: wuxin001
 * @Date: 2022/04/15/8:46
 * @Description: java.util.List 实现
 */
public interface List {


    /**
     * 添加方法
     *
     * @param data 添加数据
     */
    void add(Object data);


    /**
     * 按照索引实现删除
     *
     * @param index 索引
     */
    void remove(int index);


    /**
     * 根据内容删除节点
     *
     * @param o 节点内容
     */
    void remove(Object o);

    /**
     * 根据下标索引修改内容
     *
     * @param index   索引
     * @param newData 新内容
     */
    void set(int index, Object newData);


    /**
     * 判断对象o是存在
     * @param o 需要判断内容
     * @return false 不存在 true 存在
     */
    boolean isContains(Object o);


}
