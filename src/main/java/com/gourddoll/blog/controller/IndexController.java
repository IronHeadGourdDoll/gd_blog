package com.gourddoll.blog.controller;

import com.gourddoll.blog.constants.Constants;
import com.gourddoll.blog.entity.Blog;
import com.gourddoll.blog.entity.Tag;
import com.gourddoll.blog.service.BlogService;
import com.gourddoll.blog.service.TagService;
import com.gourddoll.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;
    @Autowired
    private UserService userService;

    int pageNumber=1;
    int commend= Constants.YES;
    int status=Constants.YES;
    int page=(pageNumber -1) * Constants.defaultPageSize;
    int size=Constants.defaultPageSize;



    @RequestMapping(value = {"/", "index"})// /或者 index都跳转到index
    public String index(Model model) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session= request.getSession();
        String username=userService.getUserNameBySession();
        session.setAttribute("username", username);

        if (username.equals("anonymousUser")) {
            username="zhangsan";
        }

        List<Blog> commendBlogList=blogService.findCommendBlogListByUsername(commend,page,size,username);
        int totalCount=blogService.findCommendBlogListByUsername(commend,page,size,username).size();
        List<Blog> newestBlogPage=blogService.findBlogListByUsername(page,size,username);
        List<Blog> readTopBlogPage=blogService.findTopBlogListByUsername(username);
        List<Tag> tagList=tagService.findAll();

        //model.addAttribute("username",username);

//        model.addAttribute("commendBlogList",blogService.findCommendBlogList(commend,page,size));
//        model.addAttribute("totalCount",blogService.findCommendBlogList(commend,page,size).size());
//        model.addAttribute("pageNumber", pageNumber);
//
//        model.addAttribute("newestBlogPage", blogService.findBlogList(page,size));
//        model.addAttribute("readTopBlogPage", blogService.findTopBlogList());
//        model.addAttribute("tagList",tagService.findAll());

        model.addAttribute("commendBlogList",commendBlogList);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("pageNumber", pageNumber);

        model.addAttribute("newestBlogPage", newestBlogPage);
        model.addAttribute("readTopBlogPage", readTopBlogPage);
        model.addAttribute("tagList",tagList);


        return "index";//index model拥有以上数据，其他的界面没有
    }

}
