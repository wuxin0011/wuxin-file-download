package com.wuxin.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author: wuxin001
 * @date: 2022/7/16 12:12
 * @Description: 文件上传工具类
 */
public class FileUtil {



    private static String prefix = "";
    private static String mapping = "//resource//";
    /*注意如果是linux环境一定要要修改，和application-web中对于映射路径一致！！*/
    private final static String saveFolder = "d://desktop//resource//";
    private final static String saveDir = "";
    private static final String saveTimeFolder = simpleDate() + "//";
    private static final int BUFFER_SIZE = 1023;

    static {
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
                String[] split = originalFilename.split("\\.");
                // 获取图片文件后缀
                String ext = split[split.length - 1];
                String fileName = simpleUUID() + "." + ext;
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

    /**
     * 文件下载
     *
     * @param request  请求
     * @param response 响应
     * @param path     文件路径
     * @return 文件
     * @throws IOException 异常
     */
    public static File downloadExcel(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
        //提供下载文件前进行压缩，即服务端生成压缩文件
        File file = new File(path);

        // 将文件压缩
        toZip(file.getAbsolutePath(), response.getOutputStream(), false);

        //1.获取要下载的文件的绝对路径
        String realPath = file.getAbsolutePath();
        //2.获取要下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf(File.separator) + 1);
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "utf-8"));
        //获取文件输入流
        InputStream in = new FileInputStream(realPath);
        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            //将缓冲区的数据输出到客户端浏览器
            out.write(buffer, 0, len);
        }
        in.close();
        return file;
    }

    /**
     * 文件压缩
     *
     * @param srcDir           指定文件路径
     * @param out              outputStream
     * @param KeepDirStructure 是否需要保留原来的文件结构
     * @throws RuntimeException 异常
     */
    public static void toZip(String srcDir, OutputStream out, boolean KeepDirStructure)
            throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(out);
            File sourceFile = new File(srcDir);
            compress(sourceFile, zos, sourceFile.getName(), KeepDirStructure);
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void compress(File sourceFile, ZipOutputStream zos, String name,
                                 boolean KeepDirStructure) throws Exception {
        byte[] buf = new byte[BUFFER_SIZE];
        if (sourceFile.isFile()) {
            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
            zos.putNextEntry(new ZipEntry(name));
            // copy文件到zip输出流中
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1) {
                zos.write(buf, 0, len);
            }
            // Complete the entry
            zos.closeEntry();
            in.close();
        } else {
            File[] listFiles = sourceFile.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                // 需要保留原来的文件结构时,需要对空文件夹进行处理
                if (KeepDirStructure) {
                    // 空文件夹的处理
                    zos.putNextEntry(new ZipEntry(name + "/"));
                    // 没有文件，不需要文件的copy
                    zos.closeEntry();
                }
            } else {
                for (File file : listFiles) {
                    // 判断是否需要保留原来的文件结构
                    if (KeepDirStructure) {
                        // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
                        // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
                        compress(file, zos, name + "/" + file.getName(), KeepDirStructure);
                    } else {
                        compress(file, zos, file.getName(), KeepDirStructure);
                    }

                }
            }
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

    public static void main(String[] args) throws IOException {
        ResourceBundle db = ResourceBundle.getBundle("db");
        System.out.println(db.getString("file"));
        Properties properties = new Properties();
        properties.load(new FileReader("db.properties"));

        String file = properties.getProperty("file");
        System.out.println(file);
    }
}
