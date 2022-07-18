package com.wuxin.utils;

import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:12
 * @Description: 文件上传工具类
 */
public class FileUtil {

    private static String prefix = "";
    private static final String FILE_PATH = "//src//main//webapp//static//resource";

    static {
        String path = Objects.requireNonNull(FileUtil.class.getClassLoader().getResource("")).getPath();
        String[] split = path.split("/target");
        prefix = split[0] + FILE_PATH;
    }

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String fileName = String.valueOf(uuid);
        System.out.println(fileName.toCharArray());
    }


    public static String fileUtil(MultipartFile file) {
        String finalPath = "";
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            // 获取文件后缀
            Assert.notNull(originalFilename, "获取不到文件名！");
            String[] split = originalFilename.split("\\.");
            // 获取图片文件后缀
            String ext = split[split.length - 1];
            String fileName = simpleUUID();
            fileName = fileName + "." + ext;
            finalPath = FILE_PATH + fileName;
            try {
                file.transferTo(new File(prefix + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return finalPath;
    }

    public static String simpleUUID() {
        return UUID().replace("-", "");
    }

    public static String UUID() {
        return UUID.randomUUID().toString();
    }
}
