package com.wuxin.service.impl;

import com.wuxin.mapper.NoticeMapper;
import com.wuxin.pojo.Notice;
import com.wuxin.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:04
 * @Description:
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper mapper;

    @Override
    public boolean add(Notice notice) {
        return mapper.add(notice) >= 1;
    }

    @Override
    public boolean update(Notice notice) {
        return mapper.update(notice) >= 1;
    }

    @Override
    public boolean delete(Integer nid) {
        return mapper.delete(nid) >= 1;
    }

    @Override
    public List<Notice> list() {
        return mapper.list();
    }
}
