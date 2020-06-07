package com.gourddoll.service.impl;

import com.gourddoll.entity.Blog;
import com.gourddoll.mapper.BlogMapper;
import com.gourddoll.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 博客表 服务实现类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    //***********************************查询所有***********************************************
    @Override
    public List<Blog> findAll() {
        return blogMapper.findAll();
    }

    @Override
    public List<Blog> findByTagId(Integer tagId) {
        return blogMapper.findByTagId(tagId);
    }

    @Override
    public List<Blog> findByCategoryId(Integer categoryId) {
        return blogMapper.findByCategoryId(categoryId);
    }

    @Override
    public List<Blog> findByBlogId(Integer blogId) {
        return blogMapper.findByBlogId(blogId);
    }



    //***********************************根据用户名查询***********************************************
    @Override
    public List<Blog> findByUsername(String username) {
        return blogMapper.findByUsername(username);
    }

    @Override
    public List<Blog> findByUsernameAndTagId(String username, Integer tagId) {
        return blogMapper.findByUsernameAndTagId(username,tagId);
    }
    @Override
    public List<Blog> findByUsernameAndCategoryId(String username, Integer categoryId) {
        return blogMapper.findByUsernameAndCategoryId(username,categoryId);
    }
}
