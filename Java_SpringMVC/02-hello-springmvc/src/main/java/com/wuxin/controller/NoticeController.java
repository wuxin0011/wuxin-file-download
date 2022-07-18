package com.wuxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wuxin001
 * @date: 2022/7/16 18:12
 * @Description:
 */
@Controller
public class NoticeController {

    @GetMapping("/notice")
    public String index() {
        return "notice";
    }
}
