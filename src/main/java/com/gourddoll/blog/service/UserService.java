package com.gourddoll.blog.service;

import com.gourddoll.blog.entity.User;
import org.springframework.security.core.Authentication;

public interface UserService {
    User findByUsername(String username);
    Authentication getAuthentication();
    String getUserNameBySession();
    String currentUser();



}
