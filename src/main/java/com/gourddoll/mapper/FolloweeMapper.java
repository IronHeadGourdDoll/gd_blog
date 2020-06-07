package com.gourddoll.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gourddoll.entity.Followee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 关注博主表 Mapper 接口
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Mapper
public interface FolloweeMapper extends BaseMapper<Followee> {

}
