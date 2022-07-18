package com.wuxin.service.impl;

import com.wuxin.pojo.File;
import com.wuxin.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:04
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public boolean add(File file) {
        return FileService.super.add(file);
    }

    @Override
    public boolean update(File file) {
        return FileService.super.update(file);
    }

    @Override
    public boolean delete(Integer id) {
        return FileService.super.delete(id);
    }

    @Override
    public List<File> list() {
        return FileService.super.list();
    }
}
