package com.wuxin.controller.admin;

import com.wuxin.pojo.Category;
import com.wuxin.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:45
 * @Description:
 */
@RequestMapping("/admin")
@Controller
public class AdminCategoryController {

    public static List<Category> list = Stream.of(
            new Category(1, "回忆"),
            new Category(2, "生日"),
            new Category(3, "笔记"),
            new Category(4, "文件"),
            new Category(5, "游戏"),
            new Category(6, "女朋友"),
            new Category(7, "老婆"),
            new Category(8, "孩子")
    ).collect(Collectors.toList());

    @GetMapping("/category")
    public String category(Model model) {
        model.addAllAttributes(R.ok(list));
        return "admin/category";
    }

}
