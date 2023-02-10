package com.wuxin.controller.admin;

import com.wuxin.exception.CustomException;
import com.wuxin.pojo.Message;
import com.wuxin.pojo.User;
import com.wuxin.service.MessageService;
import com.wuxin.utils.R;
import com.wuxin.utils.ServletUtil;
import com.wuxin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:45
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class AdminMessageController {


    @Autowired
    private MessageService messageService;


    @GetMapping(value = {"/main", ""})
    public String main(Model model) {
        long count = messageService.list().stream().filter(item -> item.getStatus() == 0).count();
        model.addAttribute(R.ok(count));
        return "admin/main";
    }

    @GetMapping("/message")
    public String message(Model model) {
        model.addAttribute(R.ok(messageService.list()));
        return "admin/message";
    }


    @ResponseBody
    @GetMapping(value = "/message/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public R deleteMessage(@RequestBody Message message) {
        boolean update = messageService.update(message);
        if (!update) {
            return R.error("修改失败");
        }
        return R.ok("修改成功！");
    }

    @ResponseBody
    @PostMapping(value = "/message/update/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public R updateStatus(@RequestParam("mid") Integer mid) {
        if (StringUtil.isNull(mid)) {
            throw new CustomException("获取不到主键信息");
        }
        boolean update = messageService.status(mid);
        if (!update) {
            return R.error("修改失败");
        }
        return R.ok("修改成功！");
    }

    @ResponseBody
    @GetMapping(value = "/message/delete/{mid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public R deleteMessage(@PathVariable("mid") Integer mid) {
        boolean delete = messageService.delete(mid);
        if (!delete) {
            return R.error("删除失败！内容不存在");
        }
        return R.ok("删除成功");
    }


    @ResponseBody
    @PostMapping(value = "/message/reply", produces = MediaType.APPLICATION_JSON_VALUE)
    public String replyMessage(@RequestParam("email") String email, @RequestParam("content") String content) {

        //邮箱功能发送

        return "admin/message";
    }
}
