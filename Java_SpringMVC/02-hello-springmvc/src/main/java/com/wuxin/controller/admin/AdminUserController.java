package com.wuxin.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:44
 * @Description:
 */
@RequestMapping("/admin")
@Controller
public class AdminUserController {
    @GetMapping("/user")
    public String user() {
        return "admin/user";
    }

    @GetMapping("/personal")
    public String personal() {
        return "admin/personal";
    }
}
