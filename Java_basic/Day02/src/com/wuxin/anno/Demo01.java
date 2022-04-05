package com.wuxin.anno;

import java.lang.annotation.*;

/**
 * @Author: wuxin001
 * @Date: 2022/03/20/13:37
 * @Description: 自定义注解实现操作
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface Demo01 {

    String value() default "username";
}
