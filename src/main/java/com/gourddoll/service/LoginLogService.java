package com.gourddoll.service;

import com.gourddoll.entity.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 登录日志表，用来度量网站访问量（访问留言板等都算）。同一ip一段时间访问无论是否登录都会插入一条记录，未登录status=0，登录为1 服务类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
public interface LoginLogService extends IService<LoginLog> {

}
