package com.wuxin.controller.admin;

import com.wuxin.exception.CustomException;
import com.wuxin.pojo.File;
import com.wuxin.service.CategoryService;
import com.wuxin.service.FileService;
import com.wuxin.utils.FileUtil;
import com.wuxin.utils.PageUtil;
import com.wuxin.utils.R;
import com.wuxin.utils.StringUtil;
import com.wuxin.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:45
 * @Description:
 */
@Controller
@RequestMapping("/admin/file")
public class AdminFileController {

    @Autowired
    FileService fileService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String file(
            @RequestParam(value = "keywords", required = false) Integer keywords,
            @RequestParam(value = "limit", defaultValue = "0") Integer limit,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            Model model) {
        // 默认加载内容
        PageUtil<FileVo, Integer> page = fileService.queryPage(keywords, limit, size);
        model.addAttribute("categoryList", categoryService.list());
        model.addAttribute("page", page);
        return "admin/file";
    }


    // @ResponseBody
    // @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    // public ModelAndView addFile(
    //         @RequestParam(value = "name", required = false) String name,
    //         @RequestParam(value = "cid", required = false) Integer cid,
    //         @RequestParam(value = "file", required = false) MultipartFile file
    // ) {
    //     if (StringUtil.isEmpty(name)) {
    //         throw new CustomException("文件名为空");
    //     }
    //     if (StringUtil.isNull(cid)) {
    //         throw new CustomException("请选择一个文件分类");
    //     }
    //     if (StringUtil.isNull(file)) {
    //         throw new CustomException("文件内容为空！");
    //     }
    //     System.out.printf("上传文件信息:=={文件名：%s,文件大小：%s}%n", name, file.getSize());
    //
    //     String url = FileUtil.fileUtil(file);
    //     if (url == null) {
    //         throw new CustomException("上传失败！");
    //     }
    //     boolean add = fileService.add(new File(null, name, url, cid, 0, new Date()));
    //     if (!add) {
    //         throw new CustomException("添加失败！");
    //     }
    //
    //     return new ModelAndView("/admin/file");
    // }


    @ResponseBody
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R addFile(@RequestParam(value = "name", required = false) String name,
                     @RequestParam(value = "cid", required = false) Integer cid,
                     @RequestParam(value = "file", required = false) MultipartFile file)
    {
        if (StringUtil.isEmpty(name)) {
            return R.error("文件名不能为！");
        }
        if (StringUtil.isNull(cid)) {
            return R.error("分类不能为空！");
        }
        if (StringUtil.isNull(file)) {
            return R.error("文件不能为空！");
        }
        System.out.printf("上传文件信息:=={文件名：%s,文件大小：%s}%n", name, file.getSize());

        String url = FileUtil.fileUtil(file);
        if (url == null) {
            throw new CustomException("上传失败！获取不到文件路径！");
        }
        boolean add = fileService.add(new File(null, name, url, cid, 0, new Date()));
        if (!add) {
            return R.error("文件添加失败！");
        }

        return R.ok("文件名不能为！");
    }

    @ResponseBody
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public R updateFile(
            @RequestParam("fid") Integer fid,
            @RequestParam("name") String name,
            @RequestParam("cid") Integer cid
    ) {
        if (StringUtil.isEmpty(name)) {
            return R.error("文件名不能为空！");
        }
        if (StringUtil.isNull(fid)) {
            return R.error("文件分类不能为空！");
        }
        if (StringUtil.isNull(cid)) {
            return R.error("文件分类不能为空！");
        }
        boolean update = fileService.update(new File(fid, name, null, cid, 1, new Date()));
        if (!update) {
            return R.error("修改失败，文件不存在！");
        }
        return R.ok("修改成功！");
    }


    @ResponseBody
    @GetMapping(value = "/delete/{fid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public R deleteFile(@PathVariable("fid") Integer fid) {
        boolean add = fileService.delete(fid);
        if (!add) {
            return R.error("修改失败！文件不存在！");
        }
        return R.ok("修改成功！");
    }
}
