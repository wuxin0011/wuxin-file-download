package com.wuxin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wuxin001
 * @Description:
 */
@RestController
public class HelloController {


    /**
     * 允许多个访问路径
     */
    @RequestMapping({"", "/hello"})
    public String hello() {
        return "hello springboot";
    }

    @RequestMapping({"/404"})
    public String error() {
        return "404错误！";
    }
}
