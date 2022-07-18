package com.wuxin.mapper;

import com.wuxin.pojo.File;
import com.wuxin.vo.FileVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:07
 * @Description:
 */

public interface FileMapper {


    /**
     * 返回文件列表
     *
     * @param name 文件名 模糊查询
     * @return list
     */
    List<File> list(@Param("name") String name);

    /**
     * 返回文件列表
     *
     * @param name 文件名 模糊查询
     * @return list
     */
    List<File> queryList(String name);

    /**
     * 根据cid获取文件分类
     *
     * @param cid category id
     * @return list
     */
    List<File> queryListByCid(int cid);

    /**
     * 联合查询，返回带有分类名的文件列表
     *
     * @return list
     */
    List<FileVo> queryListAndCategory();

    /**
     * 通过主键查询
     *
     * @param fid 主键id
     * @return DTO
     */
    File queryOne(int fid);

    /**
     * 添加
     *
     * @param file DTO
     * @return 1
     */
    int add(File file);

    /**
     * 删除
     *
     * @param fid 主键
     * @return i
     */
    int delete(int fid);

    /**
     * 修改
     *
     * @param file DTO
     * @return 1
     */
    int update(File file);
}
