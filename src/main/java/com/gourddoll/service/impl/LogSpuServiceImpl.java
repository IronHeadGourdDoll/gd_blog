package com.gourddoll.service.impl;

import com.gourddoll.entity.LogSpu;
import com.gourddoll.mapper.LogSpuMapper;
import com.gourddoll.service.LogSpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 访问博客会被记录到blog_visit_log，blogger_visit_log，login_log三个表
访问留言板，关于我等会被记录到login_log，blog_visit_log
操作会被记录到login_log，operate_log

相同ip一段时间内（2小时）重复访问只会记录一次 服务实现类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Service
public class LogSpuServiceImpl extends ServiceImpl<LogSpuMapper, LogSpu> implements LogSpuService {

}
