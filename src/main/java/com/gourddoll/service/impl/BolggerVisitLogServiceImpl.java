package com.gourddoll.service.impl;

import com.gourddoll.entity.BolggerVisitLog;
import com.gourddoll.mapper.BolggerVisitLogMapper;
import com.gourddoll.service.BolggerVisitLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博主浏览记录表（我看过谁（博客留言板等都会被记录））=》求和-网站浏览记录表 服务实现类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Service
public class BolggerVisitLogServiceImpl extends ServiceImpl<BolggerVisitLogMapper, BolggerVisitLog> implements BolggerVisitLogService {

}
