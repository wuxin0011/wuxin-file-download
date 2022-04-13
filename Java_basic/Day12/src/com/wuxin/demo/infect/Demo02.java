package com.wuxin.demo.infect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AlgorithmConstraints;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/10:59
 * @Description: 通过反射获取对象属性方法以及其他信息
 */
public class Demo02 {

    public static void main(String[] args) {

        Class<String> aClass = String.class;

        // 通过反射信息获取对象构造器
        // 获取所有构造器
        // System.out.println("========================constructors======================");
        // Constructor<?>[] constructors = aClass.getConstructors();
        // for (int i = 0; i < constructors.length; i++) {
        //     System.out.println("constructors[" + i + "]" + constructors[i]);
        // }
        p(aClass.getConstructors());

        // System.out.println("========================fields======================");
        // 获取属性
        // Field[] fields = aClass.getFields();
        // for (int i = 0; i < fields.length; i++) {
        //     System.out.println("fields[" + i + "]" + fields[i]);
        // }
        p(aClass.getFields());

        // 通过反射class字节码获取所有类方法
        // System.out.println("========================methods======================");
        // Method[] methods = aClass.getMethods();
        // for (int i = 0; i < methods.length; i++) {
        //     System.out.println("methods[" + i + "]" + methods[i]);
        // }
        p(aClass.getMethods());
        // System.out.println("========================methods======================");
        // 通过class字节码获取所有注解信息
        // Annotation[] annotations = aClass.getAnnotations();
        // for (int i = 0; i < annotations.length; i++) {
        //     System.out.println("annotations[" + i + "]" + annotations[i]);
        // }
        p(aClass.getAnnotations());


        p(aClass.getInterfaces());
    }

    public static void p(Object[] objects){
        System.out.println("========================"+objects.getClass().getSimpleName()+"======================");
        for (int i = 0; i <objects.length; i++) {
            System.out.println(objects.getClass().getSimpleName()+"[" + i + "]" + objects[i]);
        }
    }
}