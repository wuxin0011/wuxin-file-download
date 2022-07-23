package com.wuxin.controller.admin;

import com.wuxin.pojo.Notice;
import com.wuxin.service.NoticeService;
import com.wuxin.utils.R;
import com.wuxin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:45
 * @Description:
 */
@Controller
@RequestMapping("/admin/notice")
public class AdminNoticeController {


    @Autowired
    private NoticeService noticeService;

    @GetMapping("")
    public String notice(Model model) {
        model.addAttribute("notices", noticeService.list());
        return "admin/notice";
    }

    @ResponseBody
    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R addNotice(@RequestParam("title") String title, @RequestParam("content") String content) {
        if (StringUtil.isEmpty(title)) {
            return R.error("标题不能为空！");
        }
        if (StringUtil.isEmpty(content)) {
            return R.error("内容不能为空！");
        }
        boolean add = noticeService.add(new Notice(null, title, content, new Date()));
        if (!add) {
            return R.error("添加失败");
        }
        return R.ok("添加成功");

    }

    @ResponseBody
    @PostMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R updateNotice(@RequestBody Notice notice) {
        if (StringUtil.isNull(notice)) {
            return R.error("消息不能为空");
        }
        if (StringUtil.isNull(notice.getNid())) {
            return R.error("获取不到id信息");
        }
        if (StringUtil.isEmpty(notice.getTitle())) {
            return R.error("标题不能为空！");
        }
        if (StringUtil.isEmpty(notice.getContent())) {
            return R.error("内容不能为空！");
        }
        boolean update = noticeService.update(notice);
        if (!update) {
            return R.error("添加失败");
        }
        return R.ok("添加成功");
    }

    @ResponseBody
    @GetMapping(value = "/delete/{nid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R deleteNotice(@PathVariable("nid") Integer nid) {
        if (StringUtil.isNull(nid)) {
            return R.error("获取不到id信息");
        }
        boolean update = noticeService.delete(nid);
        if (!update) {
            return R.error("添加失败,该消息可能不存在！");
        }
        return R.ok("删除成功");
    }


}
