package com.wuxin.anno;

/**
 * @Author: wuxin001
 * @Date: 2022/03/20/13:39
 * @Description:
 */
public class TestDemo01 {

    public static void main(String[] args) {
        User user = new User();
        user.getUsername();
    }
}

@Demo01(value = "hello")
class User {
    @Demo01(value = "demomethod")
    public void getUsername() {
        System.out.println("自定义实现demo注解....");
    }
}
