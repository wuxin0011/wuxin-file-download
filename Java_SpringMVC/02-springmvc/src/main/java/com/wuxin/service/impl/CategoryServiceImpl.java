package com.wuxin.service.impl;

import com.wuxin.mapper.CategoryMapper;
import com.wuxin.pojo.Category;
import com.wuxin.service.CategoryService;
import com.wuxin.vo.CategoryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:04
 * @Description:
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    @Override
    public boolean add(Category category) {
        return categoryMapper.add(category) >= 1;
    }

    @Override
    public boolean update(Category category) {
        return categoryMapper.update(category) >= 1;
    }

    @Override
    public boolean delete(Integer cid) {
        return categoryMapper.delete(cid) >= 1;
    }

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    @Override
    public List<CategoryVo> queryCount() {
        return categoryMapper.queryCount();
    }


    @Override
    public Category queryOne(String name) {
        return categoryMapper.queryOneByName(name);
    }

    @Override
    public Category queryOne(Integer id) {
        return categoryMapper.queryOne(id);
    }
}
