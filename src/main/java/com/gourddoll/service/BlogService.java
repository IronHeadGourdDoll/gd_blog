package com.gourddoll.service;

import com.gourddoll.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 博客表 服务类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
public interface BlogService extends IService<Blog> {

    List<Blog> findAll();

    List<Blog> findByTagId(Integer tagId);

    List<Blog> findByCategoryId(Integer categoryId);

    List<Blog> findByBlogId(Integer blogId);

    //根据用户名查询
    List<Blog> findByUsername(String username);

    List<Blog> findByUsernameAndTagId(String username, Integer tagId);

    List<Blog> findByUsernameAndCategoryId(String username, Integer categoryId);
}
