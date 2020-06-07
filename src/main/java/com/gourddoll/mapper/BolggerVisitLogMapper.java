package com.gourddoll.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gourddoll.entity.BolggerVisitLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 博主浏览记录表（我看过谁（博客留言板等都会被记录））=》求和-网站浏览记录表 Mapper 接口
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Mapper
public interface BolggerVisitLogMapper extends BaseMapper<BolggerVisitLog> {

}
