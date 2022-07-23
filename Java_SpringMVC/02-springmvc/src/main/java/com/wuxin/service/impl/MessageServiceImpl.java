package com.wuxin.service.impl;

import com.wuxin.mapper.MessageMapper;
import com.wuxin.pojo.Message;
import com.wuxin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:04
 * @Description:
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper mapper;

    @Override
    public boolean add(Message message) {
        return mapper.add(message) >= 1;
    }

    @Override
    public Message queryOne(Integer mid) {
        return mapper.queryOne(mid);
    }

    @Override
    public boolean update(Message message) {
        return mapper.update(message) >= 1;
    }

    @Override
    public boolean status(Integer mid) {
        return mapper.status(mid) >= 1;
    }

    @Override
    public boolean delete(Integer id) {
        return mapper.delete(id) >= 1;
    }

    @Override
    public List<Message> list() {
        return mapper.list();
    }
}
