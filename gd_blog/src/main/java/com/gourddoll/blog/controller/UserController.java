package com.gourddoll.blog.controller;

import com.gourddoll.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/***
* @Description:
* @Author:  wuliang
* @Date:  2020/6/6   12:20
*/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/select")
    public String select() {
        return "select";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "delete";
    }

    @RequestMapping("/login_page")
    public String login() {
        return "login_page";
    }

    @RequestMapping("/login_error")
    public String login_error(Model model) {
        model.addAttribute("login_error", "用户名或密码错误");
        return "login_page";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("login_error", "注销成功");
        return "login_page";
    }

    @RequestMapping("/401")
    public String error() {
        return "interceptor/401";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
