package com.gourddoll.blog.controller;


import com.gourddoll.blog.constants.Constants;
import com.gourddoll.blog.entity.Blog;
import com.gourddoll.blog.entity.Category;
import com.gourddoll.blog.entity.Tag;
import com.gourddoll.blog.entity.User;
import com.gourddoll.blog.service.BlogService;
import com.gourddoll.blog.service.CategoryService;
import com.gourddoll.blog.service.TagService;
import com.gourddoll.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private CategoryService categoryService;

    int commend= Constants.YES;

    @RequestMapping(value = {"/", "index"})// /或者 index都跳转到index
    public String index(Model model, HttpServletRequest request,@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start<0?0:start;
        HttpSession session= request.getSession();
        User user=userService.getUserBySession();
        String username=user.getUsername();

//        //引入分页查询，使用PageHelper分页功能，该插件就只会对第一查询语句查询的数据进行分页,而不是对返回最终数据的查询与基础查询出来的数据进行分页.
//        //在查询之前传入当前页，然后多少记录，应该在查询数据的前面
//        //startPage后紧跟的这个查询就是分页查询，初始第pn页，每页5个
//        PageHelper.startPage(pn,3);
//        List<Blog> commendBlogList=blogService.findCommendBlogListByUsername(commend,page,size,username);
//        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
//        PageInfo pageInfo = new PageInfo<>(commendBlogList);
//        model.addAttribute("pageInfo",pageInfo);
//        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数


        Page<Blog> commendBlogPage=blogService.findCommendBlogListByUsername(commend,start,size,username);
        List<Blog> newestBlogList=blogService.findBlogListByUsername(start,size,username);

        //System.out.println(newestBlogList.get(0).tagList.get(0).tagName);

        List<Blog> readTopBlogList=blogService.findTopBlogListByUsername(start,size,username);
        List<Tag> tagList=tagService.findAll();
        List<Category> categoryList=categoryService.findAllCategory();

        model.addAttribute("commendBlogPage", commendBlogPage);
        model.addAttribute("newestBlogList", newestBlogList);
        model.addAttribute("readTopBlogList", readTopBlogList);
        session.setAttribute("tagList",tagList);

        session.setAttribute("categoryList",categoryList);
        return "index";//index model拥有以上数据，其他的界面没有
    }

}
