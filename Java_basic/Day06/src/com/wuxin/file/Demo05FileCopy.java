package com.wuxin.file;

import javax.lang.model.element.VariableElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author: wuxin001
 * @Date: 2022/03/27/23:10
 * @Description: 拷贝目录
 */
public class Demo05FileCopy {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("Day06/src/com/wuxin/file");
        File newFile = new File("copy/");
        // test("Day06/src/com/wuxin/file");
        copy(srcFile,newFile);
    }

    static void copy(File srcFile, File newFile) {
        System.out.println("源文件地址:"+srcFile.getAbsolutePath());
        System.out.println("源文件地址后缀:"+srcFile.getAbsolutePath().substring(3));
        System.out.println("复制文件地址:"+newFile.getAbsolutePath());
        if(srcFile.isFile()){
            return;
        }
        File[] files = srcFile.listFiles();
        assert files != null;
        for (File file : files) {
            if(file.isDirectory()){
                // file.getAbsolutePath() +
                String absolutePath = srcFile.getAbsolutePath();
                System.out.println(absolutePath);
                System.out.println(absolutePath.substring(3));
                copy(file,newFile);
            }
            // System.out.println(file.getAbsoluteFile());
        }

    }

    /**
     * 写入文件
     *
     * @param oldFileUrl 源文件地址
     * @param newFileUrl 新文件地址
     * @throws IOException io异常
     */
    private void readWriteFile(String oldFileUrl, String newFileUrl, boolean append) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(oldFileUrl);
        FileOutputStream fos = new FileOutputStream(newFileUrl, append);
        int read;
        byte[] bytes = new byte[1024 * 1024];
        while ((read = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, read);
        }
        // 关闭读取
        fis.close();
        // 写入关闭
        fos.close();
        fos.flush();
        long end = System.currentTimeMillis();
        System.out.println("拷贝文件地址:" + newFileUrl + "一共耗时:" + (end - start) + "ms");

    }
}
