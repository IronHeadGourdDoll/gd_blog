package com.gourddoll.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gourddoll.entity.Role;
import com.gourddoll.entity.User;
import com.gourddoll.mapper.UserMapper;
import com.gourddoll.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 用户的一些基本信息 服务实现类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    //操作json的
    @Autowired
    ObjectMapper objectMapper;

    //操作redis
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Cacheable(cacheNames = "user-1")
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
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
    public User getUserBySession() throws JsonProcessingException {
        String username,visitorName="anonymousUser";//初始默认不登陆，参观者为匿名用户
        User user,visitor=new User();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session= request.getSession();

        Authentication authentication=getAuthentication();
        //得到用户身份
        Object principal = authentication.getPrincipal();
        if (stringRedisTemplate.opsForValue().get("user") != null)//获取redis的为user的key来判断
        {
            String user1 = stringRedisTemplate.opsForValue().get("user");//获取json字符串
            username = objectMapper.readValue(user1, User.class).getUsername();//转换json为user对象并获取username
            session.setAttribute("visitor", visitor);//给session存储一个visitor
        } else {
            //System.out.println("没走缓存");
            if (principal == null) {
                System.out.println("没走缓存");
                username = visitorName;
            } else {
                if (principal instanceof UserDetails) {
                    UserDetails userDetails = (UserDetails) principal;
                    username = userDetails.getUsername();
                } else {
                    username = (String) principal;
                }
                //没登陆就看zhangsan，参观者身份为anonymousUser
                if (username.equals(visitorName)) {
                    username = "zhangsan";
                    visitor.setUsername(visitorName);
                    session.setAttribute("visitor", visitor);
                } else {                                  //登录过后自己看自己
                    visitorName = username;
                    visitor = userMapper.findByUsername(visitorName);
                    session.setAttribute("visitor", visitor);
                    String s = objectMapper.writeValueAsString(visitor);//先将visitor转换为json存储在redis
                    stringRedisTemplate.opsForValue().set("user", s);//存在redis,key为user
                }
            }
        }
        user=userMapper.findByUsername(username);
        session.setAttribute("user",user);
        return user;
    }
}
