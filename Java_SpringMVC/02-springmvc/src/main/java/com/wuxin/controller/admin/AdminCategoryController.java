package com.wuxin.controller.admin;

import com.wuxin.pojo.Category;
import com.wuxin.pojo.Notice;
import com.wuxin.service.CategoryService;
import com.wuxin.utils.R;
import com.wuxin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:45
 * @Description:
 */
@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String category(Model model) {
        model.addAttribute(R.ok(categoryService.queryCount()));
        return "admin/category";
    }


    @ResponseBody
    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R addCategory(@RequestParam("name") String name) {
        if (StringUtil.isEmpty(name)) {
            return R.error("名称不能空！");
        }
        Category category = categoryService.queryOne(name);
        if (!StringUtil.isNull(category)) {
            return R.error("添加失败！分类名已存在！");
        }

        boolean add = categoryService.add(new Category(null, name));
        if (!add) {
            return R.error("添加失败");
        }
        return R.ok("添加成功");

    }


    @ResponseBody
    @PostMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R updateCategory(@RequestParam("name") String name, @RequestParam("cid") Integer cid) {
        if (StringUtil.isNull(cid)) {
            return R.error("获取不到id信息");
        }
        if (StringUtil.isEmpty(name)) {
            return R.error("名称不能空！");
        }
        Category category = categoryService.queryOne(name);
        if (!StringUtil.isNull(category)) {
            return R.error("添加失败！该分类已存在！");
        }
        boolean update = categoryService.update(new Category(cid, name));
        if (!update) {
            return R.error("修改失败");
        }
        return R.ok("修改成功");

    }


    @ResponseBody
    @GetMapping(value = "/delete/{cid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R updateCategory(@PathVariable("cid") Integer cid) {
        if (StringUtil.isNull(cid)) {
            return R.error("获取不到id信息");
        }
        boolean add = categoryService.delete(cid);
        if (!add) {
            return R.error("删除失败！该分类不存在");
        }
        return R.ok("删除成功");

    }


}
