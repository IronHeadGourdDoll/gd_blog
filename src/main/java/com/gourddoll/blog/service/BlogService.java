package com.gourddoll.blog.service;

import com.gourddoll.blog.entity.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogService {

    //****************************在所有用户中查找****************************
    List<Blog> findTopBlogList(int start, int size);//查找博客等级前10的

    List<Blog> findBlogList(int start, int size);//查找所有博客，按时间降序

    List<Blog> findBlogReadTop(int start, int size);//查找阅读数前十的博客

    Page<Blog> findCommendBlogList(int commend, int page , int size);//查找推荐博客


    //****************************根据username查找************************************
    List<Blog> findTopBlogListByUsername(int start, int size,String username);

    List<Blog> findBlogListByUsername(int start, int size,String username);

    List<Blog> findBlogReadTopByUsername(int start, int size,String username);

    Page<Blog> findCommendBlogListByUsername(int commend, int start ,int size,String username);


    Blog findBlogByBlogId(Long BlogId);//通过id查找博客


    Page<Blog> findBlogByUsernameAndCategoryName(String username, String categoryName, int start, int size);

    Page<Blog> findBlogByUsername(String username, int start, int size);

    void deleteBlog(Blog blog);

    void saveOrUpdateBlog(Blog blog);
}
