package com.wuxin.controller;

import com.wuxin.pojo.User;
import com.wuxin.service.UserService;
import com.wuxin.utils.FileUtil;
import com.wuxin.utils.R;
import com.wuxin.utils.ServletUtil;
import com.wuxin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author: wuxin001
 * @date: 2022/7/15 12:06
 * @Description: 处理登录和注册功能
 */
@Controller
public class LoginController {


    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @ResponseBody
    @PostMapping(value = "/to/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R userLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (!StringUtil.isNotEmpty(email, password)) {
            return R.error("邮箱和密码不能为空");
        }

        if (!StringUtil.isEmail(email)) {
            return R.error("邮箱格式错误");
        }
        User login = userService.isLogin(email, password);
        if (login == null) {
            return R.error("登录失败！邮箱或者密码错误");
        }
        ServletUtil.saveLoginUser(login);
        return R.ok("登录成功！");
    }


    @ResponseBody
    @PostMapping(value = "/user/register", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R userLogin(
            @RequestParam("password") String password,
            @RequestParam("repassword") String repassword,
            @RequestParam("email") String email) {
        if (!StringUtil.isNotEmpty(email, password, repassword)) {
            return R.error("邮箱和密码不能为空");
        }
        if (!password.equals(repassword)) {
            return R.error("两次密码不一致");
        }
        if (!StringUtil.isPassword(password)) {
            return R.error("密码长度4-20");
        }
        if (!StringUtil.isEmail(email)) {
            return R.error("邮箱格式错误");
        }
        User user = userService.queryUserByEmail(email);
        if (user != null) {
            return R.error("该邮箱已经被注册了哦");
        }

        // 此处用户密码需要加密
        userService.add(new User(null, FileUtil.simpleUUID().substring(1, 10), password, email, 1, 0, new Date()));

        return R.ok("注册成功！");
    }
}
