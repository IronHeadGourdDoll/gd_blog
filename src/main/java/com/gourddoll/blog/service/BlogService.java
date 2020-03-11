package com.gourddoll.blog.service;

import com.gourddoll.blog.entity.Blog;

import java.util.List;

public interface BlogService {

    //****************************在所有用户中查找****************************
    List<Blog> findTopBlogList(int page, int size);//查找博客等级前10的

    List<Blog> findBlogList(int page, int size);//查找所有博客，按时间降序

    List<Blog> findBlogReadTop(int page, int size);//查找阅读数前十的博客

    List<Blog> findCommendBlogList(int commend, int page ,int size);//查找推荐博客


    //****************************根据username查找************************************
    List<Blog> findTopBlogListByUsername(String username);

    List<Blog> findBlogListByUsername(int page, int size,String username);

    List<Blog> findBlogReadTopByUsername(int page, int size,String username);

    List<Blog> findCommendBlogListByUsername(int commend, int page ,int size,String username);


    Blog findBlogByBlogId(Long BlogId);//通过id查找博客

    void saveBlog(Blog Blog);//发布博客
}
