package com.wuxin.mapper;

import com.wuxin.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:07
 * @Description:
 */

public interface MessageMapper {

    /**
     * 返回消息列表
     *
     * @return message list
     */
    List<Message> list();

    /**
     * 查询
     *
     * @param mid 主键id
     * @return DTO
     */
    Message queryOne(int mid);

    /**
     * 消息内容修改
     *
     * @param message DTO
     * @return 1
     */
    int update(Message message);

    /**
     * 添加
     *
     * @param message DTO
     * @return 1
     */
    int add(Message message);

    /**
     * 删除
     *
     * @param mid 主键id
     * @return 1
     */
    int delete(@Param("mid") int mid);

}
