package com.gourddoll.blog.config;

import com.gourddoll.blog.entity.Role;
import com.gourddoll.blog.entity.User;
import com.gourddoll.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role : user.getRoleList()) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        //String principal= JSON.toJSONString(user);//将user所有信息封装在username里面
        //return new org.springframework.security.core.userdetails.User(principal, user.getPwd(), simpleGrantedAuthorities);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPwd(), simpleGrantedAuthorities);
    }
}
