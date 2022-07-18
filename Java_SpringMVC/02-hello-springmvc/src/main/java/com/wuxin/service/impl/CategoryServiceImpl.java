package com.wuxin.service.impl;

import com.wuxin.pojo.Category;
import com.wuxin.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:04
 * @Description:
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public boolean add(Category category) {
        return CategoryService.super.add(category);
    }

    @Override
    public boolean update(Category category) {
        return CategoryService.super.update(category);
    }

    @Override
    public boolean delete(Integer id) {
        return CategoryService.super.delete(id);
    }

    @Override
    public List<Category> list() {
        return CategoryService.super.list();
    }
}
