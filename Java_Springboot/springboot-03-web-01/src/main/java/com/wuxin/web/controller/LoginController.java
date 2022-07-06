package com.wuxin.web.controller;

import com.sun.javafx.binding.StringFormatter;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wuxin001
 * @date: 2022/7/6 22:29
 * @Description:
 */
@RequestMapping("login")
@RestController
public class LoginController {

    @GetMapping()
    public String loginGet(@RequestParam("username") String username) {
        return hello(username, "GET");
    }


    @PostMapping()
    public String loginPost(@RequestParam("username") String username) {
        return hello(username, "POST");
    }


    @DeleteMapping()
    public String loginDelete(@RequestParam("username") String username) {
        return hello(username, "DELETE");
    }


    @PutMapping()
    public String loginPut(@RequestParam("username") String username) {
        return hello(username, "PUT");
    }


    public String hello(String username) {
        return "hello" + username;
    }

    public String hello(String username, String type) {
        return String.format("用户名: %s ,请求方式：%s", username, type);
    }
}
