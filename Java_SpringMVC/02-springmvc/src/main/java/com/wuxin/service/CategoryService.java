package com.wuxin.service;

import com.wuxin.bean.BaseService;
import com.wuxin.pojo.Category;
import com.wuxin.vo.CategoryVo;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:02
 * @Description:
 */
public interface CategoryService extends BaseService<Category> {


    List<CategoryVo> queryCount();

}
