package com.gourddoll.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.gourddoll.constant.StatusCode;
import com.gourddoll.entity.Message;
import com.gourddoll.service.MessageService;
import com.gourddoll.service.UserService;
import com.gourddoll.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public Map<String,Object> findAll() throws JsonProcessingException {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userService.getUserBySession().getUsername());

        List<Message> messages = messageService.list(queryWrapper);
        Map<String,Object> map=new HashMap<>();
        map.put("messages",messages);
        map.put("result",new Result(true, StatusCode.OK,"搜索成功"));
        return map;
    }
    @GetMapping("/{username}")
    public Map<String,Object> findByUserName(@PathVariable String username){

        List<Message> messages = messageService.findByUsername(username);
        Map<String,Object> map=new HashMap<>();
        map.put("messages",messages);
        map.put("result",new Result(true, StatusCode.OK,"搜索成功"));
        return map;
    }
}
