package com.wuxin.demo.infect;

import com.wuxin.demo.bean.A;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/19:26
 * @Description: // 通过反射获取私有构造方法
 */
public class Demo07 {

    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("com.wuxin.demo.bean.A");

        // 获取属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            System.out.println(declaredField);
        }

        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            // 开启访问权限
            declaredConstructor.setAccessible(true);
            // 该方式只能获取无参构造方法
            A a = (A) declaredConstructor.newInstance();
            System.out.println(a);
        }

    }


}

