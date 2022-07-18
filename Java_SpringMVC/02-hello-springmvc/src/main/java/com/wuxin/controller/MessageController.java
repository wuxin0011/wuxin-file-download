package com.wuxin.controller;

import com.wuxin.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: wuxin001
 * @date: 2022/7/16 18:12
 * @Description:
 */
@Controller
public class MessageController {


    @GetMapping("/message")
    public String index() {
        return "message";
    }

    @PostMapping("/message/add")
    public ModelAndView add(@RequestParam("email") String email, @RequestParam("content") String content) {
        ModelAndView view = new ModelAndView("message");
        if (StringUtil.isEmpty(content)) {
            view.addObject("content", "内容不能为空！");
            return view;
        }
        if (!StringUtil.isEmail(email)) {
            view.addObject("email", "邮箱格式错误！");
            return view;
        }
        // 这里将消息内容方锐数据库中
        view.addObject("success", "消息发送成功！");
        return view;
    }
}
