package com.wuxin.demo.anno;

import com.wuxin.demo.bean.Man;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/21:09
 * @Description: 实现id注解，如果该注解中没有 int/integer id字段，就会报错！
 */
public class IdImpl {


    public static void main(String[] args) throws Exception {
        // 获取注解信息
        Class<?> annClass = Class.forName("com.wuxin.demo.anno.Id");
        System.out.println(annClass);
        // 获取类信息
        Class<Man> manClass = Man.class;
        // 获取该类注解信息
        Annotation[] annotations = manClass.getAnnotations();
        for (Annotation annotation : annotations) {
            // 判断是否含有该注解
            System.out.println(annotation.getClass());
            if (annotation instanceof Id) {
                // 如果该类含有该注解 需要判断类中是否有 int id字段
                Field idField = null;
                try {
                    idField = manClass.getDeclaredField("id");
                    System.out.println(idField);
                    // 对应字段不为null同时必须是int
                    String simpleName = idField.getType().getSimpleName();
                    if ("int".equals(simpleName) || "Integer".equals(simpleName)) {
                        System.out.println("success");
                        return;
                    }
                    throw new Exception("使用注解 @Id 必须要 int/integer id字段");
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Exception("使用注解 @Id 必须要 int/integer id字段");
                }

            }
        }

    }

}
