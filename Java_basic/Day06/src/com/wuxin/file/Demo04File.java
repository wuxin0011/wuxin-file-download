package com.wuxin.file;

import java.io.File;
import java.util.Arrays;

/**
 * @Author: wuxin001
 * @Date: 2022/03/27/22:50
 * @Description: 抽象表示的文件和目录的路径名。
 */
public class Demo04File {
    public static void main(String[] args) {
        test01();
    }

    static void test01() {
        File file = new File("D:\\desktop\\github\\Java\\Java_basic\\Day06\\file01.txt");
        if (file == null) {
            return;
        }
        System.out.println(file.length());
        System.out.println(file.getPath());
        System.out.println("file" + file);
        System.out.println("getParent" + file.getParent());
        System.out.println("getParentFile" + file.getParentFile());
        File file1 = new File("Day06/src/com/wuxin/file/Demo04File.java");
        System.out.println("file1 is null?" + file1 == null);
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getAbsolutePath());
        Object o = new Object();
        o.hashCode();
        // System.out.println(Arrays.toString();
        for (File listFile : file1.getParentFile().listFiles()) {
            System.out.println("name"+listFile.getName());
        }
    }
}
