package com.gourddoll.service.impl;

import com.gourddoll.entity.OperateLog;
import com.gourddoll.mapper.OperateLogMapper;
import com.gourddoll.service.OperateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志，增删改都会记录 服务实现类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {

}
