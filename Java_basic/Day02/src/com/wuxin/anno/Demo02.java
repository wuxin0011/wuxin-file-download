package com.wuxin.anno;

import java.lang.annotation.*;

/**
 * @Author: wuxin001
 * @Date: 2022/03/20/13:43
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Demo02 {

    String value() default "username";

    int count() default 1;

}
