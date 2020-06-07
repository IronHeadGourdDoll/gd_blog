package com.gourddoll.service;

import com.gourddoll.entity.LogSpu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 访问博客会被记录到blog_visit_log，blogger_visit_log，login_log三个表
访问留言板，关于我等会被记录到login_log，blog_visit_log
操作会被记录到login_log，operate_log

相同ip一段时间内（2小时）重复访问只会记录一次 服务类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
public interface LogSpuService extends IService<LogSpu> {

}
