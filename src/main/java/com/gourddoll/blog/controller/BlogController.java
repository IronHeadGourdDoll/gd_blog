package com.gourddoll.blog.controller;

import com.gourddoll.blog.entity.Blog;
import com.gourddoll.blog.entity.User;
import com.gourddoll.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            blog.setBlogId(0L);
        }
        model.addAttribute("blog",blog);
        System.out.println("blog:"+blog);
        return "edit_article";
    }

    //跳转到添加/编辑界面,@RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)，根据key对应成实体
    @PostMapping("/save_or_update")
    @ResponseBody
    public String saveOrUpdateBlog(Model model, @RequestBody Blog blog) {
        blogService.saveOrUpdateBlog(blog);
        return "success";//?categoryName=blog.categoryName
    }

    //删除
    @RequestMapping("/delete_blog")
    public String deleteBlog(Blog blog) {
        blogService.deleteBlog(blog);
        return "redirect:index";
    }
}
