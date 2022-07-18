package com.wuxin.service.impl;

import com.wuxin.pojo.Notice;
import com.wuxin.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:04
 * @Description:
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Override
    public boolean add(Notice notice) {
        return NoticeService.super.add(notice);
    }

    @Override
    public boolean update(Notice notice) {
        return NoticeService.super.update(notice);
    }

    @Override
    public boolean delete(Integer id) {
        return NoticeService.super.delete(id);
    }

    @Override
    public List<Notice> list() {
        return NoticeService.super.list();
    }
}
