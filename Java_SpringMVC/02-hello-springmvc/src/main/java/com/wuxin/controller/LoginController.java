package com.wuxin.controller;

import com.wuxin.pojo.User;
import com.wuxin.service.UserService;
import com.wuxin.utils.ServletUtil;
import com.wuxin.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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


    @PostMapping("/to/login")
    public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        boolean login = userService.isLogin(email, password);
        if (login) {
            ServletUtil.saveLoginUser(new User(1, "张三", password, email, 1, 1, new Date()));
            return "forward:index";
        } else {
            model.addAttribute("result", "邮箱或者密码错误！");
            return "forward:login";
        }
    }


    @PostMapping("/user/register")
    public String userLogin(
            @RequestParam("password") String password,
            @RequestParam("repassword") String repassword,
            @RequestParam("email") String email,
            Model model) {
        if (StringUtil.isEmpty(password) || StringUtil.isEmpty(repassword)) {
            return "forward:/register";
        }
        if (!StringUtil.isEqual(password, repassword)) {
            return "forward:/register";
        }
        if (!StringUtil.isPassword(password) || StringUtil.isEmail(email)) {
            return "forward:/register";
        }

        // 添加用户到数据库
        userService.add(new User(null, "", password, email, 1, 1, new Date()));
        return "index";
    }
}
