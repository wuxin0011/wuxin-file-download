package com.wuxin.controller;

import com.wuxin.pojo.Message;
import com.wuxin.service.MessageService;
import com.wuxin.utils.R;
import com.wuxin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public R add(@RequestParam("email") String email, @RequestParam("content") String content) {
        if (StringUtil.isEmpty(content)) {
            return R.error("内容不能为空");
        }
        if (!StringUtil.isEmail(email)) {
            return R.error("邮箱格式错误");
        }
        // 将内容提交到数据库中
        messageService.add(new Message(null, content, email, 0, new Date()));
        // 将消息通知给邮箱
        return R.ok("消息发送成功！");
    }


}
