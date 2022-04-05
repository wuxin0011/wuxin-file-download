package com.wuxin.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: wuxin001
 * @Date: 2022/03/27/21:20
 * @Description: FileInputStream 文件字节输入流 任何文件都可以采用该文件输入 完成读的操作 从硬盘到内存的过程
 */
public class Demo01FileInputStreamDemo {
    public static void main(String[] args) {
        // test();
        test01();
    }

    static void test() {
        FileInputStream bs = null;
        try {
            // idea 默认项目读取路径是项目包的根路径
            bs = new FileInputStream("Day06/file01.txt");
            System.out.println(bs);
            bs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static void test01() {
        FileInputStream fis = null;
        try {
            // 使用绝对路径读取文件
            // fis = new FileInputStream("D:\\desktop\\github\\Java\\Java_basic\\Day06\\file01.txt");
            // 使用相对路径
            fis = new FileInputStream("Day06/file01.txt");
            System.out.println(fis);
            byte[] b = new byte[4];
            int read = 0;
            // 读取起始位置
            while ((read = fis.read(b)) != -1) {
                System.out.print(new String(b, 0, read));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭操作 流不能为空
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
