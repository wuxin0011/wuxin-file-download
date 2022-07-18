package com.wuxin.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:45
 * @Description:
 */
@RequestMapping("/admin")
@Controller
public class AdminNoticeController {

    @GetMapping("/notice")
    public String notice() {
        return "admin/notice";
    }
}
