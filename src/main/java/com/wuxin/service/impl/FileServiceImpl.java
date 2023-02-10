package com.wuxin.service.impl;

import com.wuxin.mapper.FileMapper;
import com.wuxin.pojo.File;
import com.wuxin.service.FileService;
import com.wuxin.utils.PageUtil;
import com.wuxin.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:04
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public boolean add(File file) {
        return fileMapper.add(file) >= 1;
    }

    @Override
    public boolean update(File file) {
        return fileMapper.update(file) >= 1;
    }

    @Override
    public boolean delete(Integer fid) {
        return fileMapper.delete(fid) >= 1;
    }

    @Override
    public List<File> list() {
        return fileMapper.list(null);
    }

    @Override
    public List<FileVo> queryListAndCategory(int cid) {
        return fileMapper.queryListAndCategory(cid);
    }

    @Override
    public PageUtil<FileVo, Integer> queryPage(Integer cid, Integer limit, Integer size) {
        List<FileVo> fileVos = fileMapper.queryPage(cid, limit, size);
        int count = fileMapper.count(cid);
        return new PageUtil<>(cid, limit, size, count, fileVos);
    }

    @Override
    public boolean deleteByCid(Integer cid) {
        return fileMapper.deleteByCid(cid) > 0;
    }

    @Override
    public File queryOne(Integer id) {
        return fileMapper.queryOne(id);
    }
}
