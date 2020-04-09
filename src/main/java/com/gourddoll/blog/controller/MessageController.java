package com.gourddoll.blog.controller;

import com.gourddoll.blog.entity.Message;
import com.gourddoll.blog.entity.User;
import com.gourddoll.blog.service.MessageService;
import com.gourddoll.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MessageController {
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;

    @GetMapping("/message")
    public String message(Model model, HttpServletRequest request, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        HttpSession session= request.getSession();
        User user=userService.getUserBySession();
        String username=user.getUsername();
        Page<Message> messagePage=messageService.findMessageByUsername(username,start,size);

        model.addAttribute("messagePage",messagePage);
        return "message";
    }
    @PostMapping("/leave_message")
    @ResponseBody
    public String leaveMessage(@RequestBody Message message) {
        messageService.leaveMessageByUsername(message);
        return "success";
    }
}
