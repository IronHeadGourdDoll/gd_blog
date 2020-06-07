package com.gourddoll.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gourddoll.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}
