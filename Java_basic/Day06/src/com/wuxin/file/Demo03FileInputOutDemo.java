package com.wuxin.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: wuxin001
 * @Date: 2022/03/27/22:35
 * @Description: 读取文件同时写入文件
 */
public class Demo03FileInputOutDemo {

    public static void main(String[] args) throws IOException {
        Demo03FileInputOutDemo fio = new Demo03FileInputOutDemo();

        fio.readWriteFile("Day06/file01.txt", "Day06/test.txt", true);
        fio.readWriteFile("Day06/file01.txt", "Day06/hello.world.txt", false);
        fio.readWriteFile("D:\\desktop\\doc\\css.chm", "D:\\desktop\\doc\\css.backup1.chm", false);

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
        System.out.println("拷贝文件地址:"+newFileUrl+"一共耗时:" + (end - start) + "ms");

    }


}
