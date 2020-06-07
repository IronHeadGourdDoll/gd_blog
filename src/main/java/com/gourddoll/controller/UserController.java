package com.gourddoll.controller;


import com.gourddoll.constant.StatusCode;
import com.gourddoll.entity.User;
import com.gourddoll.service.UserService;
import com.gourddoll.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户的一些基本信息 前端控制器
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("findAll")
    public Map<String,Object> findAll(Integer page, Integer rows){
        Map<String, Object> map = new HashMap<>();
        List<User> users = userService.findAll();
        map.put("total", 10);
        map.put("totalPage", 1);
        map.put("page", page);
        map.put("users", users);
        return map;
    }
    @GetMapping("username")
    public Map<String,Object> getUserByName(String username){
        Map<String, Object> map = new HashMap<>();
        User user = userService.findByUsername(username);
        boolean status = (user != null);

        map.put("user", user);
        map.put("result",new Result(status, StatusCode.OK,"查找成功"));
        return map;
    }

    @GetMapping("/logout")
    public Map<String, Object> logout(Model model) {
        model.addAttribute("login_error", "注销成功");
        Map<String, Object> map = new HashMap<>();
        map.put("result",new Result(true,StatusCode.OK,"注销成功"));
        return map;
    }
}
