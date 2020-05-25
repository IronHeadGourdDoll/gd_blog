package com.gourddoll.blog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gourddoll.blog.entity.User;
import org.springframework.security.core.Authentication;

public interface UserService {
    User findByUsername(String username);
    Authentication getAuthentication();
    User getUserBySession() throws JsonProcessingException;



}