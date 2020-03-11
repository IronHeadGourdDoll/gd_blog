package com.gourddoll.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AboutController {
    @RequestMapping(value="/about",method= RequestMethod.GET)
    public String about(Model model) {
        //model.addAttribute("articleList", articleService.findIsTopArticleList());
        return "about";
    }
}
