package com.wuxin.utils;

import com.wuxin.exception.CustomException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:12
 * @Description: 文件上传工具类
 */
public class FileUtil {


    private static String prefix = "";
    private static String mapping = "";
    /*注意如果是linux环境一定要要修改，和application-web中对于映射路径一致！！*/
    public static String dir = "";
    public static String saveFolder = "";
    private static final String saveTimeFolder = simpleDate() + "//";
    private static final int BUFFER_SIZE = 1024;


    static {

        try {
            ResourceBundle location = ResourceBundle.getBundle("location");
            mapping = location.getString("mapping");
            dir = location.getString("dir");
            saveFolder = dir + mapping;
        } catch (Exception e) {
            e.printStackTrace();
        }
        prefix = saveFolder + saveTimeFolder;


    }


    /**
     * 文件上传到指定地址 注意Linux环境和windows地址不同，需要修改
     *
     * @param file 上传的文件
     * @return 返回保存到数据库的文件地址
     */
    public static String fileUtil(MultipartFile file) {
        String fileMappingPath = null;
        if (!file.isEmpty()) {
            try {
                // 检查文件夹是否存在
                File file1 = new File(prefix);
                if (!file1.exists()) {
                    file1.mkdirs();
                }
                String originalFilename = file.getOriginalFilename();
                // 获取文件后缀
                if (StringUtil.isEmpty(originalFilename)) {
                    return null;
                }

                String fileName = simpleUUID() + ext(originalFilename);
                // 映射路径 通过域名+映射路径访问
                fileMappingPath = mapping + saveTimeFolder + fileName;
                // 文件保存的绝对路径
                String savePath = prefix + fileName;
                file.transferTo(new File(savePath));
            } catch (IOException e) {
                e.printStackTrace();
                fileMappingPath = null;
            }
        }

        return fileMappingPath;
    }


    public static void download(String name, String url) {
        if (StringUtil.isEmpty(url)) {
            throw new CustomException("文件路径为空！");
        }

        File file = new File(dir + url);
        if (!file.exists()) {
            throw new CustomException("文件不存在！");
        }

        try {
            HttpServletResponse response = ServletUtil.getResponse();
            //获取文件输入流
            InputStream bis = new BufferedInputStream(new FileInputStream(file));

            // 获取文件后缀
            String filename = name + ext(file.getName());
            filename = URLEncoder.encode(filename, "UTF-8");

            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            //设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            byte[] bytes = new byte[BUFFER_SIZE * BUFFER_SIZE];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("文件下载失败！");
        }

    }


    public static String simpleUUID() {
        return UUID().replace("-", "");
    }

    public static String UUID() {
        return UUID.randomUUID().toString();
    }


    public static String simpleDate() {
        return new SimpleDateFormat("yyyy/MM").format(new Date());
    }


    public static String ext(String filePath) {
        if (StringUtil.isEmpty(filePath)) {
            return "." + simpleUUID().substring(1, 5) + "empty";
        }
        String[] split = filePath.split("\\.");
        return "." + split[split.length - 1];
    }

    public static void remove(com.wuxin.pojo.File obj) {
        remove(obj, true);
    }

    public static void remove(com.wuxin.pojo.File obj, boolean isremove) {

        if (obj != null && isremove) {
            String url1 = obj.getUrl();
            if (url1 != null) {
                File file = new File(dir + url1);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }
}
