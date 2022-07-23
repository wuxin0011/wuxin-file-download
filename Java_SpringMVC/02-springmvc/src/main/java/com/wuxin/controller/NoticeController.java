package com.wuxin.controller;

import com.wuxin.service.NoticeService;
import com.wuxin.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wuxin001
 * @date: 2022/7/16 18:12
 * @Description:
 */
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice")
    public String index(Model model) {
        model.addAttribute(R.ok(noticeService.list()));
        return "notice";
    }


}
