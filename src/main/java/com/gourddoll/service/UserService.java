package com.gourddoll.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gourddoll.entity.Role;
import com.gourddoll.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * <p>
 * 用户的一些基本信息 服务类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
public interface UserService extends IService<User> {
    List<User> findAll();

    User findByUsername(String username);

    Authentication getAuthentication();

    User getUserBySession() throws JsonProcessingException;
}
