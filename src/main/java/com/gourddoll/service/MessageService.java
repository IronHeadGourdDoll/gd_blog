package com.gourddoll.service;

import com.gourddoll.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
public interface MessageService extends IService<Message> {

    List<Message> findByUsername(String username);
}
