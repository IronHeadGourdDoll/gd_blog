package com.gourddoll.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gourddoll.entity.Message;
import com.gourddoll.mapper.MessageMapper;
import com.gourddoll.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Message> findByUsername(String username) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return messageMapper.selectList(queryWrapper);
    }
}
