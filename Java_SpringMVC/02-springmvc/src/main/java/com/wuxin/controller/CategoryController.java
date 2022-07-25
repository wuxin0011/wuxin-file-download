package com.wuxin.controller;

import com.wuxin.exception.CustomException;
import com.wuxin.service.CategoryService;
import com.wuxin.service.FileService;
import com.wuxin.utils.FileUtil;
import com.wuxin.utils.R;
import com.wuxin.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wuxin001
 * @Description:
 */
@Controller
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FileService fileService;


    @GetMapping("/category/{cid}")
    public String content(@PathVariable("cid") Integer cid, Model model) {
        if (cid == null) {
            throw new CustomException(402, "获取不到分类");
        }
        R ok = R.ok(fileService.queryListAndCategory(cid));
        ok.put("cid", cid);
        model.addAttribute(ok);
        return "category";
    }


    @GetMapping(value = "/category/list", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public R list() {
        List<CategoryVo> collect = categoryService.queryCount().stream().filter(item -> item.getCount() > 0).collect(Collectors.toList());
        return R.ok(collect);
    }


    @PostMapping("/file/download")
    public void content(
            @RequestParam("url") String url,
            @RequestParam("name") String name
    ) {
        FileUtil.download(name, url);
    }


}
