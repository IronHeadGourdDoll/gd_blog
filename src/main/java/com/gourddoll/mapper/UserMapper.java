package com.gourddoll.mapper;

import com.gourddoll.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import com.gourddoll.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户的一些基本信息 Mapper 接口
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByUsername(String username);

    List<User> findAll();
}
