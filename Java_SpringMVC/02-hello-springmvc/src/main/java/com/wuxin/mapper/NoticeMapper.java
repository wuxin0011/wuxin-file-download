package com.wuxin.mapper;

import com.wuxin.pojo.Message;
import com.wuxin.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:07
 * @Description:
 */

public interface NoticeMapper {

    /**
     * 返回通知列表
     *
     * @return list
     */
    List<Notice> list();

    /**
     * 查询
     *
     * @param mid 主键id
     * @return DTO
     */
    Notice queryOne(@Param("mid") int mid);

    /**
     * 修改
     *
     * @param notice DTO
     * @return 1
     */
    int update(Notice notice);

    /**
     * 添加
     *
     * @param notice DTO
     * @return 1
     */
    int add(Notice notice);

    /**
     * 删除
     *
     * @param mid 主键
     * @return 1
     */
    int delete(@Param("mid") int mid);
}
