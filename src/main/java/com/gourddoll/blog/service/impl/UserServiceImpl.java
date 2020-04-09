package com.gourddoll.blog.service.impl;

import com.gourddoll.blog.constants.Constants;
import com.gourddoll.blog.entity.User;
import com.gourddoll.blog.repository.UserRepository;
import com.gourddoll.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    int Yes= Constants.YES;
    int NO=Constants.NO;


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public Authentication getAuthentication() {
//        //获取当前用户详细信息,第一次为空，后面正常
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        SecurityContextImpl securityContextImpl = (SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//        if (securityContextImpl!=null){
//            // 登录名
//            Authentication authentication=securityContextImpl.getAuthentication();
//            System.out.println("Username:" + authentication.getName());
//            // 登录密码，未加密的
//            System.out.println("Credentials:" + authentication.getCredentials());
//            WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
//            // 获得访问地址
//            System.out.println("RemoteAddress:" + details.getRemoteAddress());
//            // 获得sessionid
//            System.out.println("SessionId:" + details.getSessionId());
//            return authentication;
//        }else {
//            return null;
//        }
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    @Override
    public User getUserBySession(){
        String username,visitorName="anonymousUser";//初始默认不登陆，参观者为匿名用户
        User user,visitor=new User();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session= request.getSession();

        Authentication authentication=getAuthentication();
        //得到用户身份
        Object principal=authentication.getPrincipal();
        if (principal==null){
            username=visitorName;
        }else {
            if (principal instanceof UserDetails){
                UserDetails userDetails=(UserDetails)principal;
                username=userDetails.getUsername();
            }else{
                username= (String) principal;
            }
            //没登陆就看zhangsan，参观者身份为anonymousUser
            if(username.equals(visitorName)) {
                username="zhangsan";
                visitor.setUsername(visitorName);
                session.setAttribute("visitor",visitor);
            }else{                                  //登录过后自己看自己
                visitorName=username;
                visitor=userRepository.findByUsername(visitorName);
                session.setAttribute("visitor",visitor);
            }
        }

        user=userRepository.findByUsername(username);
        session.setAttribute("user",user);
        return user;
    }

}
