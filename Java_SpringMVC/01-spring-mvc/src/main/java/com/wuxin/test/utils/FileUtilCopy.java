package com.wuxin.test.utils;

import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @author: wuxin001
 * @date: 2022/7/20 12:19
 * @Description:
 */
public class FileUtilCopy {

    private static String prefix = "";
    private static String mapping = "//resource//";
    private final static String saveFolder = "d://desktop//resource//";
    private static final String saveTimeFolder = simpleDate() + "//";

    static {
        prefix = saveFolder + saveTimeFolder;
    }

    public static void main(String[] args) {

    }


    public static String fileUtil(MultipartFile file) {
        String fileMapping = mapping;
        if (!file.isEmpty()) {
            // 如果创建文件夹日期不存在就添加
            File file1 = new File(prefix);
            if (!file1.exists()) {
                file1.mkdirs();
            }

            String originalFilename = file.getOriginalFilename();
            // 获取文件后缀
            Assert.notNull(originalFilename, "获取不到文件名！");
            String[] split = originalFilename.split("\\.");
            // 获取图片文件后缀
            String ext = split[split.length - 1];
            String fileName = simpleUUID();
            fileName = fileName + "." + ext;
            // 映射路径
            fileMapping = fileMapping + saveTimeFolder + fileName;
            // 文件保存的绝对路径
            String absoultePath = prefix + fileName;
            System.out.println(absoultePath);
            try {
                file.transferTo(new File(absoultePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return fileMapping;
    }


    public static String simpleUUID() {
        return UUID().replace("-", "");
    }

    public static String UUID() {
        return UUID.randomUUID().toString();
    }


    public static String simpleDate() {
        return new SimpleDateFormat("yyyy//MM").format(new Date());
    }
}
