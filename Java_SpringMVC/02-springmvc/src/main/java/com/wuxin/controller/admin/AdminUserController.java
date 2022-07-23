package com.wuxin.controller.admin;

import com.wuxin.pojo.User;
import com.wuxin.service.UserService;
import com.wuxin.utils.R;
import com.wuxin.utils.ServletUtil;
import com.wuxin.utils.StringUtil;
import com.wuxin.vo.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: wuxin001
 * @date: 2022/7/16 11:44
 * @Description:
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;


    @GetMapping("")
    public String userList(@RequestParam(value = "keywords", required = false) String keywords, Model model) {
        List<User> list = userService.list(keywords);
        model.addAttribute("userList", list);
        return "admin/user";
    }

    @GetMapping("/personal")
    public String personal() {
        return "admin/personal";
    }

    @ResponseBody
    @PostMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R update(@RequestBody User user) {

        if (StringUtil.isNull(user)) {
            R.error("获取不到用户信息");
        }

        if (StringUtil.isNull(user.getId())) {
            R.error("获取不到用户id信息");

        }

        if (!StringUtil.isEmail(user.getEmail())) {
            R.error("邮箱格式错误！");
        }

        if (!StringUtil.isUsername(user.getUsername())) {
            R.error("用户名格式错误，2-15");
        }

        User dbUser = userService.queryOne(user.getId());
        if (StringUtil.isNull(dbUser)) {
            R.error("用户不存在");
        }

        // 比较用户信息
        if (!user.getUsername().equals(dbUser.getUsername())) {
            User user1 = userService.queryUserByName(user.getUsername());
            if (user1 != null) {
                return R.error(402, "用户名被占用！");
            }
        }

        if (!user.getEmail().equals(dbUser.getEmail())) {
            User user1 = userService.queryUserByEmail(user.getEmail());
            if (user1 != null) {
                return R.error(402, "邮箱被占用！");
            }
        }

        // 密码加密对比数据库密码

        boolean update = userService.update(user);
        if (!update) {
            return R.error("用户信息修改失败！");
        }
        return R.ok("修改成功！");
    }

    @ResponseBody
    @PostMapping(value = "/person/change", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R personChange(@RequestBody UpdateUser user) {
        if (user != null && user.getId() != null) {
            User loginUser = ServletUtil.getLoginUser();
            if (loginUser != null && user.getId().equals(loginUser.getId())) {
                if ((StringUtil.isEmpty(user.getPassword()) && !StringUtil.isEmpty(user.getRepassword())) || (!StringUtil.isEmpty(user.getPassword()) && StringUtil.isEmpty(user.getRepassword()))) {
                    return R.error(402, "密码不相等！");
                }

                if (StringUtil.isNotEmpty(user.getPassword(), user.getRepassword())) {

                    if (!user.getPassword().equals(user.getRepassword())) {
                        return R.error(402, "密码不相等！");
                    }
                    if (!StringUtil.isPassword(user.getPassword())) {
                        return R.error(402, "密码4-15！");
                    }

                }


                if (!user.getUsername().equals(loginUser.getUsername())) {
                    if (!StringUtil.isUsername(user.getUsername())) {
                        return R.error(402, "用户名2-15！");

                    }
                    User user1 = userService.queryUserByName(user.getUsername());
                    if (user1 != null) {
                        return R.error(402, "用户名被占用！");
                    }
                }

                if (!user.getEmail().equals(loginUser.getEmail())) {
                    if (!StringUtil.isEmail(user.getEmail())) {
                        return R.error(402, "邮箱格式错误！");
                    }
                    User user1 = userService.queryUserByEmail(user.getEmail());
                    if (user1 != null) {
                        return R.error(402, "邮箱被占用！");
                    }
                }


                boolean update = userService.update(new User(user.getId(), user.getUsername(), null, user.getEmail(), loginUser.getStatus(), loginUser.getRole(), null));
                if (update) {
                    return R.ok("修改成功！");
                } else {
                    return R.error(402, "修改失败！用户只能修改自己信息");
                }
            } else {
                return R.error(402, "获取不到登录用户信息");
            }

        }
        return R.error("获取不到用户信息！");
    }


    @ResponseBody
    @GetMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R delete(@PathVariable("id") Integer id) {
        if (id == null) {
            return R.error("获取不到id信息");
        }
        boolean delete = userService.delete(id);
        if (!delete) {
            return R.error("删除失败！用户不存在！");
        }
        return R.ok("删除成功");
    }


    @ResponseBody
    @GetMapping(value = "/logout", produces = {MediaType.APPLICATION_JSON_VALUE})
    public R logout() {
        ServletUtil.getSession().removeAttribute("loginUser");
        return R.ok("退出成功！");
    }

}
