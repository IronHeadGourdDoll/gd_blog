package com.gourddoll.blog.config;

import com.gourddoll.blog.entity.Menu;
import com.gourddoll.blog.entity.Role;
import com.gourddoll.blog.repository.RoleRepository;
import com.gourddoll.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.util.List;

/*** 
* @Description:  
* @Author: Wuliang
* @Date: 2020/3/9 
*/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired private
    UserService userService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //配置资源文件 其中/css/**，/index可以任意访问，/select需要USER权限，/delete需要ADMIN权限
        httpSecurity
                .csrf().disable()//屏蔽csrf，跨站请求伪造
                .authorizeRequests()
                .antMatchers("/css/**", "/index","about").permitAll()
                .antMatchers("/blog/comment").hasRole("USER")//hasAuthority("USER")
                .antMatchers("/system/sys_index").hasRole("ADMIN");
        //动态加载数据库中角色权限
        List<Role> roleList = roleRepository.findAll();
        for (Role role : roleList) {
            List<Menu> menuList = role.getMenuList();
            for (Menu menu : menuList) {
                //在SpringSecurity校验权限的时候，会自动将权限前面加ROLE_，所以我们需要 将我们数据库中配置的ROLE_截取掉。
                String roleName = role.getRoleName().replace("ROLE_", "");
                String menuName = "/" + menu.getMenuName();
                httpSecurity
                        .authorizeRequests()
                        .antMatchers(menuName)
                        .hasRole(roleName);
            }
        }
        //配置登录请求页面/login_page 登录失败请求/login_error 登录成功请求/
        httpSecurity
                .formLogin()//允许表单登录
                .loginPage("/login_page").loginProcessingUrl("/login")//自定义登录界面,自定义登录链接
                .failureUrl("/login_error")
                .successForwardUrl("/index")
                .permitAll()//允许所有访问登陆界面
        .and()
                .logout().logoutSuccessUrl("/login")
                .logoutSuccessUrl("/login_page")
                .invalidateHttpSession(true)
         .and().rememberMe()//登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
                .tokenValiditySeconds(1209600)
                .and().csrf().disable();
        //登录异常，如权限不符合 请求/401
        httpSecurity
                .exceptionHandling().accessDeniedPage("/interceptor/401");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


    //根据用户名密码实现登录
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(myUserDetailsService);
    }
}
