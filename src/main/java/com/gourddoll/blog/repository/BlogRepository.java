package com.gourddoll.blog.repository;

import com.gourddoll.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//所有排序在impl层手动调整
public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

    Blog findByBlogId(Long blogId);//通过id查找博客

    //*****************************查找所有博客*******************************
    Page<Blog> findAllByStatus(int status, Pageable pageable);//page要加一个额外参数，查找所有博客
    Page<Blog> findAllByCommendAndStatus(int commend, int status, Pageable pageable);

    //*********************************根据username查找博客**********************************
    Page<Blog> findAllByStatusAndAuthor(int status, Pageable pageable,String author);//通过作者查找所有博客
    Page<Blog> findAllByCommendAndStatusAndAuthor(int commend,int status, Pageable pageable,String author);//通过作者查找推荐的所有博客



}
