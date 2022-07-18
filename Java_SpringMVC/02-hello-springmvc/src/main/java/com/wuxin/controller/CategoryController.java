package com.wuxin.controller;

import com.wuxin.pojo.Category;
import com.wuxin.pojo.File;
import com.wuxin.pojo.User;
import com.wuxin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: wuxin001
 * @Description:
 */
@Controller
public class CategoryController {

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public CategoryController() {
        System.out.println("categoryController==========================》");
    }

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/category/{cid}")
    public String content(@PathVariable("cid") Integer cid, Model model) {
        ArrayList<File> files = new ArrayList<>();
        files.add(new File(1, "背景图1", "/resource/bg1.jpg", cid, 1,new Date()));
        files.add(new File(2, "背景图2", "/resource/bg2.jpg", cid, 1,new Date()));
        files.add(new File(3, "背景图3", "/resource/bg3.jpg", cid, 1,new Date()));
        files.add(new File(4, "背景图4", "/resource/bilibili.png", cid, 1,new Date()));
        model.addAttribute("cid", cid);
        model.addAttribute("files", files);
        return "category";
    }


    @ResponseBody
    @GetMapping("/category/list")
    public List<Category> list() {
        return new ArrayList<>();
    }
}
