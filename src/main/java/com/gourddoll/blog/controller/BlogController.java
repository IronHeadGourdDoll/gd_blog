package com.gourddoll.blog.controller;

import com.gourddoll.blog.service.BlogService;
import com.gourddoll.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;

    @GetMapping("/article")
    public String category(Model model) {
        //model.addAttribute("articleList", articleService.findIsTopArticleList());
        return "article";
    }
    //归档
    @GetMapping("/pigeonhole")
    public String pigeonhole(Model model) {
        //model.addAttribute("articleList", articleService.findIsTopArticleList());
        return "pigeonhole";
    }
}
