package com.wuxin.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:54
 * @Description: 数据库基本操作接口 使用jdk8接口可以默认实现，继承了不一定要实现全部方法
 */
public interface BaseService<T> {

    /**
     * 添加
     *
     * @param t 实体类
     * @return true 添加成功
     */
    default boolean add(T t) {
        return false;
    }


    /**
     * 修改
     *
     * @param t 实体类
     * @return true 添加成功
     */
    default boolean update(T t) {
        return false;
    }

    /**
     * 删除
     *
     * @param id 主键id
     * @return true 删除成功
     */
    default boolean delete(Integer id) {
        return false;
    }

    /**
     * 查询方法
     *
     * @return 返回实体类列表
     */
    default List<T> list() {
        return new ArrayList<>();
    }

    /**
     * 查询方法
     *
     * @param keywords 关键字
     * @return 返回实体类列表
     */
    default List<T> list(String keywords) {
        return new ArrayList<>();
    }

    /**
     * 查询方法
     *
     * @param id id
     * @return 返回实体类列表
     */
    default T queryOne(Integer id) {
        return null;
    }


}
