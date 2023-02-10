package com.wuxin.controller;

import com.wuxin.pojo.Category;
import com.wuxin.service.CategoryService;
import com.wuxin.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * @author: wuxin001
 * @date: 2022/7/15 11:57
 * @Description:
 */
@Controller
public class IndexController {


    @Autowired
    private  CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        // model.addAttribute("categoryList", categoryService.list());
        return "index";
    }

    @GetMapping("/error")
    public String error(Model model) {
        model.addAllAttributes(R.error(404, "访问路径不存在！！！"));
        return "error";
    }

}
