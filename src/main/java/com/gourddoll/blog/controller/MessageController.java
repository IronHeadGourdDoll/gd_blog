package com.gourddoll.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
    @GetMapping("/message")
    public String index(Model model) {
        //model.addAttribute("articleList", articleService.findIsTopArticleList());
        return "message";
    }
}
