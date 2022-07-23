package com.wuxin.controller;

import com.wuxin.pojo.Message;
import com.wuxin.service.MessageService;
import com.wuxin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author: wuxin001
 * @date: 2022/7/16 18:12
 * @Description:
 */
@Controller
public class MessageController {


    @Autowired
    private MessageService messageService;


    @GetMapping("/message")
    public String index() {
        return "message";
    }

    @PostMapping("/message/add")
    public ModelAndView add(@RequestParam("email") String email, @RequestParam("content") String content) {
        ModelAndView view = new ModelAndView("message");
        if (StringUtil.isEmpty(content)) {
            view.addObject("contentError", "内容不能为空！");
            return view;
        }
        if (!StringUtil.isEmail(email)) {
            view.addObject("emailError", "邮箱格式错误！");
            return view;
        }
        // 将内容提交到数据库中
        view.addObject("message", "消息发送成功！");
        messageService.add(new Message(null, content, email, 0, new Date()));
        return view;
    }
}
