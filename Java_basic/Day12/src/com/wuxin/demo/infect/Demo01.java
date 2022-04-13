package com.wuxin.demo.infect;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/10:51
 * @Description: 反射
 */
public class Demo01 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取class字节码的三种方式
        // 方式一通过包名导入获取
        Class<?> c1 = Class.forName("java.lang.String");
        System.out.println(c1);

        // 方式二通过getClass方法获取
        String s = new String("hello world");
        Class<? extends String> aClass = s.getClass();
        System.out.println(aClass);

        // 方式三、通过 类名.class方式获取
        Class<String> stringClass = String.class;
        System.out.println(stringClass);


        System.out.println(c1 == aClass);
        System.out.println(c1 == stringClass);
    }
}
