package com.wuxin.controller.admin;

import com.wuxin.pojo.Message;
import com.wuxin.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:45
 * @Description:
 */
@RequestMapping("/admin")
@Controller
public class AdminMessageController {

    public static List<Message> list = Stream.of(
            new Message(1, "内容0", "2191377749@qq.com", 0, new Date()),
            new Message(2, "内容1", "2191377749@qq.com", 1, new Date()),
            new Message(3, "内容2", "2191377749@qq.com", 1, new Date()),
            new Message(4, "内容3", "2191377749@qq.com", 0, new Date()),
            new Message(5, "内容4", "2191377749@qq.com", 1, new Date()),
            new Message(6, "内容5", "2191377749@qq.com", 0, new Date()),
            new Message(7, "内容6", "2191377749@qq.com", 1, new Date()),
            new Message(8, "内容7", "2191377749@qq.com", 0, new Date()),
            new Message(9, "内容9", "2191377749@qq.com", 1, new Date())
    ).collect(Collectors.toList());


    @GetMapping(value = {"/main", ""})
    public String main(Model model) {
        model.addAttribute(R.ok(100).put("username", "wuxin"));
        return "admin/main";
    }

    @GetMapping("/message")
    public String message(Model model) {
        model.addAttribute(R.ok(list));
        return "admin/message";
    }
}
