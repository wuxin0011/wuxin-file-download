package com.wuxin.service;

import com.wuxin.bean.BaseService;
import com.wuxin.pojo.Message;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:01
 * @Description:
 */
public interface MessageService extends BaseService<Message> {


    /**
     * 修改状态
     * @param mid
     * @return int
     */
    boolean status(Integer mid);
}
