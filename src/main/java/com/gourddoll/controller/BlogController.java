package com.gourddoll.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.gourddoll.constant.StatusCode;
import com.gourddoll.entity.Blog;
import com.gourddoll.service.BlogService;
import com.gourddoll.service.UserService;
import com.gourddoll.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客表 前端控制器
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@RestController
@CrossOrigin
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;

    //************************************************************查询所有***************************************************
    @GetMapping("/article")
    public Map<String,Object> getAll(){
        Map<String, Object> map = new HashMap<>();
        List<Blog> blogs= blogService.findAll();
        map.put("blogs",blogs);
        map.put("result",new Result(true, StatusCode.OK,"查找成功"));
        return map;
    }

    @GetMapping("/article/detail/{blogId}")
    public Map<String,Object> getAll(@PathVariable Integer blogId){
        Map<String, Object> map = new HashMap<>();
        List<Blog> blogs= blogService.findByBlogId(blogId);
        map.put("blogs",blogs);
        map.put("result",new Result(true, StatusCode.OK,"查找成功"));
        return map;
    }

    @GetMapping("/article/tag/{tagId}")
    public Map<String,Object> getByTag(@PathVariable Integer tagId){
        Map<String, Object> map = new HashMap<>();
        List<Blog> blogs= blogService.findByTagId(tagId);
        map.put("blogs",blogs);
        map.put("result",new Result(true, StatusCode.OK,"查找成功"));
        return map;
    }
    @GetMapping("/article/category/{categoryId}")
    public Map<String,Object> getByCategory(@PathVariable Integer categoryId){
        Map<String, Object> map = new HashMap<>();
        List<Blog> blogs= blogService.findByCategoryId(categoryId);
        map.put("blogs",blogs);
        map.put("result",new Result(true, StatusCode.OK,"查找成功"));
        return map;
    }


    //*****************************************根据用户名查询*****************************************************
    @GetMapping("/{username}/article")
    public Map<String,Object> getByUsername(@PathVariable String username) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        List<Blog> blogs= blogService.findByUsername(userService.getUserBySession().getUsername());
        map.put("blogs",blogs);
        map.put("result",new Result(true, StatusCode.OK,"查找成功"));
        return map;
    }
    @GetMapping("/{username}/article/tag/{tagId}")
    public Map<String,Object> getByUsernameAndTagId(@PathVariable String username,@PathVariable Integer tagId) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        username=userService.getUserBySession().getUsername();
        List<Blog> blogs= blogService.findByUsernameAndTagId(username,tagId);
        map.put("blogs",blogs);
        map.put("result",new Result(true, StatusCode.OK,"查找成功"));
        return map;
    }
    @RequestMapping("/{username}/article/category/{categoryId}")
    public Map<String,Object> getByUsernameAndCategoryId(@PathVariable String username,@PathVariable Integer categoryId) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        List<Blog> blogs= blogService.findByUsernameAndCategoryId(username,categoryId);
        map.put("blogs",blogs);
        map.put("result",new Result(true, StatusCode.OK,"查找成功"));
        return map;
    }
}
