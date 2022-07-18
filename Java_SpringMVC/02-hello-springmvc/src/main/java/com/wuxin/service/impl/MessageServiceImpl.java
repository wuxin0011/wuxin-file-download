package com.wuxin.service.impl;

import com.wuxin.pojo.Message;
import com.wuxin.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:04
 * @Description:
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public boolean add(Message message) {
        return MessageService.super.add(message);
    }

    @Override
    public boolean update(Message message) {
        return MessageService.super.update(message);
    }

    @Override
    public boolean delete(Integer id) {
        return MessageService.super.delete(id);
    }

    @Override
    public List<Message> list() {
        return MessageService.super.list();
    }
}
