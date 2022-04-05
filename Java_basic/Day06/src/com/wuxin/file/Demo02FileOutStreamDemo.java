package com.wuxin.file;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: wuxin001
 * @Date: 2022/03/27/22:10
 * @Description:
 */
public class Demo02FileOutStreamDemo {
    public static void main(String[] args) throws IOException {
        Demo02FileOutStreamDemo fs = new Demo02FileOutStreamDemo();
        // fs.test01();
        fs.test02();
    }

    void test01() throws IOException {
        // 创建文件
        byte[] bytes = {97, 98, 99};
        FileOutputStream fos = new FileOutputStream("Day06/file02.txt");
        fos.write(bytes);
    }

    void test02() throws IOException {
        // 创建文件
        byte[] bytes = {97, 98, 99};
        // 以追加方式写入文件内容
        FileOutputStream fos = new FileOutputStream("Day06/file03.txt",true);
        fos.write(bytes);
    }
}
