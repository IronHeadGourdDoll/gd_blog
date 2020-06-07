package com.gourddoll.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gourddoll.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> findAll();
}
