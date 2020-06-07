package com.gourddoll.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gourddoll.entity.BlogLiked;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 博客点赞表 Mapper 接口
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Mapper
public interface BlogLikedMapper extends BaseMapper<BlogLiked> {

}
