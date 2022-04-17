package com.wuxin.services;

import com.wuxin.pojo.Dept;

import java.util.List;

/**
 * @Author: wuxin001
 * @Date: 2022/04/16/22:46
 * @Description:
 */
public interface DeptService {

    /**
     * 添加 部门
     *
     * @param dept 实体
     * @return 1 表示添加成功
     */
    int addDept(Dept dept);


    /**
     * 删除部门
     *
     * @param id 部门id
     * @return 1 表示添加成功
     */
    int delDept(int id);


    /**
     * 修改部门
     *
     * @param dept 实体
     * @return 1 表示添加成功
     */
    int updateDept(Dept dept);


    /**
     * 部门列表
     *
     * @return list
     */
    List<Dept> listDept();

}
