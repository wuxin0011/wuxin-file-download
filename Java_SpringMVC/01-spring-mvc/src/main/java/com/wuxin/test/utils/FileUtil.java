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
public class FileUtil {
    private static String prefix = "";
    private static String disk = "";

    private final static String saveFolder = "//image//";
    private static final String FILE_PATH = "//src//main//webapp//static" + saveFolder;
    private static final String saveTimeFolder = simpleDate() + "//";

    static {
        String path = Objects.requireNonNull(FileUtil.class.getClassLoader().getResource("")).getPath();
        String[] split = path.split("/target");
        prefix = split[0] + FILE_PATH + saveTimeFolder;
    }

    public static void main(String[] args) {
        // UUID uuid = UUID.randomUUID();
        // String fileName = String.valueOf(uuid);
        // System.out.println(fileName.toCharArray());
        System.out.println(prefix);
        String path = FileUtil.class.getClassLoader().getResource(String.valueOf((new File("").toPath()))).getPath();
        System.out.println(path);
        System.out.println("==================");
        find(path);
    }


    public static String fileUtil(MultipartFile file) {
        String savePath = saveFolder;
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
            savePath = saveFolder + saveTimeFolder + fileName;
            // 文件保存的绝对路径
            String absoultePath = prefix + fileName;
            System.out.println(absoultePath);
            try {
                file.transferTo(new File(absoultePath));
            } catch (IOException e) {
                e.printStackTrace();
                // throw new Exception("文件上传失败！");
            }
        }

        return savePath;
    }


    public static String find(String path) {
        File file = new File(path);
        String parent = file.getParent();
        File[] list = new File(parent).listFiles();
        if (list != null || list.length != 0) {


        }
        return null;
    }

    public static String simpleUUID() {
        return UUID().replace("-", "");
    }

    public static String UUID() {
        return UUID.randomUUID().toString();
    }


    public static String simpleDate() {
        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }
}
