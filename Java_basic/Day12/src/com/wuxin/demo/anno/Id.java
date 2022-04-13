package com.wuxin.demo.anno;

import java.lang.annotation.*;

/**
 * @Author: wuxin001
 * @Date: 2022/04/13/21:06
 * @Description: 自定义id注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.TYPE})
public @interface Id {
}
