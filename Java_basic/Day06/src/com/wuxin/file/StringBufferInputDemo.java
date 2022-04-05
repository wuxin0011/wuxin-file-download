package com.wuxin.file;

import java.io.StringBufferInputStream;
import java.io.StringWriter;

/**
 * @Author: wuxin001
 * @Date: 2022/03/27/23:10
 * @Description: 该方法已经过时了
 */
public class StringBufferInputDemo {
    public static void main(String[] args) {
        StringBufferInputDemo st = new StringBufferInputDemo();
        // st.test01();
        st.test02();
    }


    void test01() {
        StringBufferInputStream inputStream = new StringBufferInputStream("file03.txt");
        int read = inputStream.read();
        System.out.println(read);
    }

    void test02() {
        // StringWriter 一个字符流，它收集在一个字符串缓冲区的输出，然后可以用来构建一个字符串。
        StringWriter stringWriter = new StringWriter(1000);
        stringWriter.write("hello StringWriter ");
        stringWriter.append('7');
        System.out.println(stringWriter);
    }
}
