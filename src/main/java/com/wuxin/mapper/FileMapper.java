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
     * @param cid   文件名 模糊查询
     * @param limit 文件名 模糊查询
     * @param size  文件名 模糊查询
     * @return list
     */
    List<FileVo> queryPage(@Param("cid") Integer cid, @Param("limit") Integer limit, @Param("size") Integer size);


    /**
     * 文件数量
     *
     * @return total
     */
    int count(@Param("cid") Integer cid);

    /**
     * 返回文件列表
     *
     * @param name 文件名 模糊查询
     * @return list
     */
    List<File> queryList(@Param("name") String name);

    /**
     * 根据cid获取文件分类
     *
     * @param cid category id
     * @return list
     */
    List<File> queryListByCid(@Param("cid") Integer cid);

    /**
     * 联合查询，返回带有分类名的文件列表
     *
     * @return list
     */
    List<FileVo> queryListAndCategory(@Param("cid") Integer cid);

    /**
     * 通过主键查询
     *
     * @param fid 主键id
     * @return DTO
     */
    File queryOne(@Param("fid") Integer fid);

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
    int delete(@Param("fid") Integer fid);

    /**
     * 删除
     *
     * @param cid 主键
     * @return i
     */
    int deleteByCid(@Param("cid") Integer cid);

    /**
     * 修改
     *
     * @param file DTO
     * @return 1
     */
    int update(File file);
}
