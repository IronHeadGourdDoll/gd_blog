package com.gourddoll.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gourddoll.entity.Medal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 徽章表 Mapper 接口
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Mapper
public interface MedalMapper extends BaseMapper<Medal> {

}
