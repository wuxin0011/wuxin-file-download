package com.wuxin.controller;

import com.wuxin.pojo.Category;
import com.wuxin.utils.R;
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


    @GetMapping(value = {"/", "/index", "/home"})
    public String index(Model model) {
        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "日记"));
        categoryList.add(new Category(2, "游戏"));
        categoryList.add(new Category(3, "科技"));
        categoryList.add(new Category(4, "说明"));
        model.addAttribute("categoryList", categoryList);
        return "index";
    }

    @GetMapping("/error")
    public String error(Model model) {
        model.addAllAttributes(R.error(404, "访问路径不存在！！！"));
        return "error";
    }

}
