package com.gourddoll.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gourddoll.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 博客表 Mapper 接口
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    //***********************************查询所有***********************************************
    List<Blog> findAll();

    List<Blog> findByBlogId(Integer blogId);

    List<Blog> findByTagId(Integer tagId);

    List<Blog> findByCategoryId(Integer categoryId);



    //***********************************根据用户名查询***********************************************
    List<Blog> findByUsername(String username);

    List<Blog> findByUsernameAndTagId(String username, Integer tagId);

    List<Blog> findByUsernameAndCategoryId(String username, Integer categoryId);
}
