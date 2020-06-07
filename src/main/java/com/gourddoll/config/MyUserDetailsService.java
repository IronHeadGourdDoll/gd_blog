package com.gourddoll.config;

import com.gourddoll.entity.Role;
import com.gourddoll.entity.User;
import com.gourddoll.mapper.UserMapper;
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
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        //String principal= JSON.toJSONString(user);//将user所有信息封装在username里面
        //return new org.springframework.security.core.userdetails.User(principal, user.getPwd(), simpleGrantedAuthorities);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPwd(),simpleGrantedAuthorities);
    }
}
