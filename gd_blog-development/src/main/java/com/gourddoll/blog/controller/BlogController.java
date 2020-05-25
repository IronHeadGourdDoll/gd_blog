package com.gourddoll.blog.controller;

import com.gourddoll.blog.entity.Blog;
import com.gourddoll.blog.entity.User;
import com.gourddoll.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    //根据分类查找博客
    @RequestMapping("/blog")
    public String getBlogByUsernameAndCategoryName(Model model, String categoryName, HttpServletRequest request,@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        HttpSession session= request.getSession();
        User user=(User) session.getAttribute("user");
        String username=user.getUsername();

        Page<Blog> blogPage=blogService.findBlogByUsernameAndCategoryName(username,categoryName,start,size);

        model.addAttribute("categoryName",categoryName);
        model.addAttribute("blogPage",blogPage);
        return "article";
    }

    //查看文章详情
    @RequestMapping("/blog_detail")
    public String getBlogByBlog(Model model, Blog blog) {
        model.addAttribute("blog",blog);
        return "article_detail";
    }


    //归档
    @RequestMapping("/pigeonhole")
    public String pigeonhole(Model model,String categoryName, HttpServletRequest request,@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "20") int size) throws Exception {
        start = start<0?0:start;
        HttpSession session= request.getSession();
        User user=(User) session.getAttribute("user");
        String username=user.getUsername();
        Page<Blog> blogPage=blogService.findBlogByUsername(username,start,size);

        model.addAttribute("blogPage",blogPage);
        return "pigeonhole";
    }

    //跳转到添加界面
    @RequestMapping("/save_or_update_page")
    public String toAddBlogPage(Model model,Blog blog) {
        if (blog!=null){

        }else{
            blog.setId(0L);
        }
        model.addAttribute("blog",blog);
        System.out.println("blog:"+blog);
        return "edit_article";
    }
    
    /**
    * @Description: 跳转到添加/编辑界面,@RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)，根据key对应成实体
    * @Param: [model, blog]
    * @return: java.lang.String
    * @Author: wuliang
    * @Date: 2020/4/23 21:10
    */
    @PostMapping("/save_or_update")
    @ResponseBody
    public String saveOrUpdateBlog(@RequestBody Blog blog, RedirectAttributes attributes) {
        blogService.saveOrUpdateBlog(blog);

        //要在save后面，save过后blog也会改变
        attributes.addFlashAttribute("blog",blog);
        return "redirect:/saved_blog";
    }

    /** 
    * @Description: 
    * @Param: [blog]
    * @return: java.lang.String
    * @Author: wuliang
    * @Date: 2020/4/23 21:11
    */ 
    @RequestMapping("/delete_blog")
    public String deleteBlog(Blog blog) {
        blogService.deleteBlog(blog);
        return "redirect:index";
    }

    //查看文章详情
    @RequestMapping("/saved_blog")
    public String getBlogById(Model model, @ModelAttribute("blog") Blog blog) {
        model.addAttribute("blog",blog);
        return "article_detail";
    }
}
