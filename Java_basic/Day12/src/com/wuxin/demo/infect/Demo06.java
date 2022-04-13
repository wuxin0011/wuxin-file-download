package com.wuxin.demo.infect;

import com.wuxin.demo.bean.User;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/17:11
 * @Description:
 */
public class Demo06 {

    public static void main(String[] args) throws Exception {

        user();

    }

    static void user() throws Exception {
        Class<?> aClass = Class.forName("com.wuxin.demo.bean.User");
        StringBuffer buffer = new StringBuffer();
        String mt = Modifier.toString(aClass.getModifiers());
        // 获取类名 模式
        buffer.append(mt).append(" class ").append(aClass.getSimpleName()).append(" { \n");

        getField(aClass, buffer);
        getConstructor(aClass, buffer);
        getMethod(aClass, buffer);


        buffer.append("\n }");
        System.out.println(buffer);
    }

    /**
     * 获取属性
     */
    public static void getField(Class<?> aClass, StringBuffer buffer) {
        // 获取属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            buffer.append("\n\t");
            buffer.append(Modifier.toString(declaredField.getModifiers()));
            buffer.append(" ");
            buffer.append(declaredField.getType().getSimpleName());
            buffer.append(" ");
            buffer.append(declaredField.getName());
            buffer.append(" ; ");

        }
    }

    /**
     * 获取构造器
     */
    public static void getConstructor(Class<?> aClass, StringBuffer buffer) {
        // 获取构造方法
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            buffer.append("\n");
            buffer.append("\t");
            buffer.append(Modifier.toString(declaredConstructor.getModifiers()));
            buffer.append(" ");
            buffer.append(aClass.getSimpleName());
            buffer.append("(");
            // 获取构造方法参数类型
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                buffer.append(parameterTypes[i].getSimpleName());
                // 判断是不是最后一个参数 最后一参数不需要添加 “，”
                if (i < parameterTypes.length - 1) {
                    buffer.append(",");
                }
            }

            buffer.append(")");
            buffer.append("{").append("}");
            buffer.append("\n");
        }

    }

    /**
     * 获取方法
     */
    public static void getMethod(Class<?> aClass, StringBuffer buffer) {
        // 获取所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            buffer.append("\n\t");
            // 获取方法修饰符
            buffer.append(Modifier.toString(declaredMethod.getModifiers()));
            // 获取方法关键字
            // System.err.println(declaredMethod.getDeclaringClass());
            // 获取方法返回值类型
            buffer.append(" ").append(declaredMethod.getReturnType().getSimpleName());
            // 获取方法名
            buffer.append(" ").append(declaredMethod.getName());
            // 获取方法参数
            buffer.append(" ( ");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                buffer.append(parameterTypes[i].getSimpleName());
                // 判断是不是最后一个参数 最后一参数不需要添加 “，”
                if (i < parameterTypes.length - 1) {
                    buffer.append(",");
                }
            }
            buffer.append(" )");
            buffer.append("{}");
        }
    }


    /**
     * 获取注解信息
     */
    private static void getAnnoInfo(Object[] objects, StringBuffer buffer) {
        // 判断是否为属性注解
        if (objects instanceof Field[]) {

        }
        // 是否为方法注解
        if (objects instanceof Method[]) {

        }
        // 方法中参数变量注解
        if (objects instanceof Class[]) {

        }

    }


}
