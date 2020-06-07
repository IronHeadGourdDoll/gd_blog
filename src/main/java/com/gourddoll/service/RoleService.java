package com.gourddoll.service;

import com.gourddoll.entity.Menu;
import com.gourddoll.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gourddoll.entity.User;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
public interface RoleService extends IService<Role> {
    List<Role> findAll();
}
