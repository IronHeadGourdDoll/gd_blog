package com.gourddoll.blog.repository;

import com.gourddoll.blog.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageRepository extends JpaRepository<Message,Long>, JpaSpecificationExecutor<Message> {

    Page<Message> findAllMessageByUsername(String username,Pageable pageable);

}
