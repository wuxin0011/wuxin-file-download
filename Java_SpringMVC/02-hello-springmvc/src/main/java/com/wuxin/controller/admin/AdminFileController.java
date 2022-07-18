package com.wuxin.controller.admin;

import com.wuxin.pojo.File;
import com.wuxin.utils.DateUtil;
import com.wuxin.utils.FileUtil;
import com.wuxin.utils.R;
import com.wuxin.utils.StringUtil;
import com.wuxin.vo.FileVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:45
 * @Description:
 */
@RequestMapping("/admin")
@Controller
public class AdminFileController {


    @GetMapping("/file")
    public String file(Model model) {
        ArrayList<FileVo> files = new ArrayList<>();
        files.add(new FileVo(1, "/resource/bg1.jpg", "bg1.jpg", new Date(), 1, "java1"));
        files.add(new FileVo(2, "/resource/bg2.jpg", "bg2.jpg", new Date(), 1, "java2"));
        files.add(new FileVo(3, "/resource/bg3.jpg", "bg3.jpg", new Date(), 1, "java22"));
        files.add(new FileVo(4, "/resource/bilibili.png", "bilibili.jpg", new Date(), 1, "java213213"));
        R ok = R.ok(files);
        model.addAttribute(ok);
        return "admin/file";
    }


    @PostMapping("/file/upload/add")
    public String addFile(
            @RequestParam("name") String name,
            @RequestParam(value = "file", required = false) MultipartFile file,
            Model model
    ) {
        System.out.println(String.format("上传文件信息:=={文件名：%s,文件大小：%s}", name, file.getClass()));

        if (!StringUtil.isNull(file)) {
            String filePath = FileUtil.fileUtil(file);
            model.addAttribute("filePath", filePath);
        }
        return "admin/file";
    }


    @PostMapping("/file/upload/update")
    public String updateFile(
            @RequestParam("name") String name,
            @RequestParam("url") String url,
            @RequestParam(value = "file", required = false) MultipartFile file,
            Model model
    ) {
        System.out.println(String.format("上传文件信息:=={文件名：%s,文件地址%，文件大小：%s}", name, url, file));

        if (!StringUtil.isNull(file)) {
            String filePath = FileUtil.fileUtil(file);
            model.addAttribute("filePath", filePath);
        }
        return "admin/file";
    }
}
