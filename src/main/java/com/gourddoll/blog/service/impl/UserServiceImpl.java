package com.gourddoll.blog.service.impl;

import com.gourddoll.blog.entity.User;
import com.gourddoll.blog.repository.UserRepository;
import com.gourddoll.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 获取当前用户详细信息,第一次为空，后面正常
     */
    @Override
    public Authentication getAuthentication() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SecurityContextImpl securityContextImpl = (SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        if (securityContextImpl!=null){
            // 登录名
            Authentication authentication=securityContextImpl.getAuthentication();
            System.out.println("Username:" + authentication.getName());
            // 登录密码，未加密的
            System.out.println("Credentials:" + authentication.getCredentials());
            WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
            // 获得访问地址
            System.out.println("RemoteAddress:" + details.getRemoteAddress());
            // 获得sessionid
            System.out.println("SessionId:" + details.getSessionId());
            return authentication;
        }else {
            return null;
        }
    }

    @Override
    public String currentUser() {
        Authentication authentication=getAuthentication();
        User user=new User();
        String username="匿名";
        //为空则设置为匿名身份
        if (authentication==null){
            System.out.println("testttttttttttttttttttttttt:"+authentication);
            return username;
        }
        //得到用户身份
        Object principal=authentication.getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails userDetails=(UserDetails)principal;//自定义的userdetailservice的username(principal)，password的username
            username=userDetails.getUsername();
        }else{
            username= (String) principal;
        }
        System.out.println("your username is:"+username);
        return username;
    }

    //在session中查找username,会被clear，为空
    @Override
    public String getUserNameBySession(){
        String username;
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        //得到用户身份
        Object principal=authentication.getPrincipal();
        if (principal==null){
            username="匿名";
        }
        if (principal instanceof UserDetails){
            UserDetails userDetails=(UserDetails)principal;
            username=userDetails.getUsername();
        }else{
            username= (String) principal;
        }
        System.out.println("your username is"+username);
        return username;
    }

}
