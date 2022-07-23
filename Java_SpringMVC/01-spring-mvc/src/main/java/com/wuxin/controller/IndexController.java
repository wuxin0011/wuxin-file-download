package com.wuxin.controller;

import com.wuxin.test.entiy.Category;
import com.wuxin.mapper.CategoryMapper;
import com.wuxin.test.utils.FileUtilCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/20 10:26
 * @Description:
 */
@Controller
public class IndexController {


    @Autowired
    private CategoryMapper categoryMapper;


    @GetMapping(value = {""})
    public String index(Model model) {
        List<Category> list = new ArrayList<>();
        try {
            list = categoryMapper.list();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("list", list);
        return "index";
    }

    @PostMapping(value = {"upload"})
    public String upload(Model model, @RequestParam("file") MultipartFile file) {
        try {
            model.addAttribute("fileName", file.getOriginalFilename());
            String s = FileUtilCopy.fileUtil(file);
            System.out.println("文件映射路径:" + s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }
}
