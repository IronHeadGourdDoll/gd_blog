package com.gourddoll.blog.service;

import com.gourddoll.blog.entity.Message;
import org.springframework.data.domain.Page;

public interface MessageService {
    Page<Message> findMessageByUsername(String username, int start, int size);

    Message leaveMessageByUsername(Message message);
}
