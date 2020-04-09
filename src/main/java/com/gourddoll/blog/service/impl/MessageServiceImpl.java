package com.gourddoll.blog.service.impl;

import com.gourddoll.blog.entity.Message;
import com.gourddoll.blog.repository.MessageRepository;
import com.gourddoll.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;
    Pageable pageable;//通过创建时间数降序排列

    @Override
    public Page<Message> findMessageByUsername(String username, int start, int size) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");//通过创建时间数降序排列
        return messageRepository.findAllMessageByUsername(username,pageable);
    }

    @Override
    public Message leaveMessageByUsername(Message message) {
        message.setCreateTime(new Date());
        return messageRepository.save(message);
    }
}
