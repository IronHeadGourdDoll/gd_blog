package com.gourddoll.blog.service.impl;

import com.gourddoll.blog.entity.Message;
import com.gourddoll.blog.repository.MessageRepository;
import com.gourddoll.blog.service.MessageService;
import com.gourddoll.blog.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;
    //通过创建时间数降序排列
    Pageable pageable;
    String nowTime= TimeUtil.getTimestamp();

    @Override
    public Page<Message> findMessageByUsername(String username, int start, int size) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");
        return messageRepository.findAllMessageByUsername(username,pageable);
    }

    @Override
    public Message leaveMessageByUsername(Message message) {
        message.setCreateTime(nowTime);
        return messageRepository.save(message);
    }
}
