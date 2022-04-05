package com.wuxin.io;

import com.wuxin.io.bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wuxin001
 * @Date: 2022/03/28/12:10
 * @Description:
 */
public class SerializableDemo01 {

    public static void main(String[] args) throws Exception {
        // test02();
        test01();
    }

    // 序列化
    private static void test01() throws Exception {
        // ObjectInputStream 只有对象支持java.io.serializable或java.io.externalizable接口可以读取流。
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.txt"));
        Object o = ois.readObject();
        if(o instanceof List){
            List<User> users = (List<User>) o;
            users.forEach(System.out::println);
        }
       ois.close();

    }

    private static void test02() throws IOException {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "张三"));
        users.add(new User(2, "李四"));
        users.add(new User(3, "王二麻子"));

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("users.txt"));
        os.writeObject(users);
        os.flush();
        os.close();
    }
}
