package com.wuxin.web.controller;

import com.wuxin.web.pojo.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wuxin001
 * @date: 2022/7/6 5:25
 * @Description:
 */
@RestController
public class MyRestController {


    @PostMapping("/saveuser")
    public User saveUser(User user) {
        return user;
    }

}
