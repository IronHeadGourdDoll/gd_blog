package com.gourddoll.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @RequestMapping("/admin/index")
    public String toAdminIndex(HttpServletResponse response){
        response.addHeader("x-frame-options","SAMEORIGIN");
        return "admin/index";
    }

    //nav url
    //文章管理
    @RequestMapping("/admin/page/news/newsList")
    public String toAdminNewsList(){
        return "admin/page/news/newsList";
    }
    //图片管理
    @RequestMapping("/admin/page/img/images")
    public String toAdminImages(){
        return "admin/page/img/images";
    }
    //404
    @RequestMapping("/admin/page/404")
    public String toAdmin404(){
        return "admin/page/404";
    }
    //管理员登录
    @RequestMapping("/admin/page/login/login")
    public String toAdminLogin(){
        return "admin/page/login/login";
    }
    //用户列表
    @RequestMapping("/admin/page/user/userList")
    public String toAdminUserList(){
        return "admin/page/user/userList";
    }
    //会员等级
    @RequestMapping("/admin/page/user/userGrade")
    public String toAdminUserGrade(){
        return "admin/page/404";
    }
    //系统基本参数
    @RequestMapping("/admin/page/systemSetting/basicParameter")
    public String toAdminSystemSettingBasicParameter(){
        return "admin/page/systemSetting/basicParameter";
    }
    //系统日志
    @RequestMapping("/admin/page/systemSetting/logs")
    public String toAdminSystemSettingLogs(){
        return "admin/page/systemSetting/logs";
    }
    //友情链接
    @RequestMapping("/admin/page/systemSetting/linkList")
    public String toAdminSystemSettingLinkList(){
        return "admin/page/systemSetting/linkList";
    }
    //图标管理
    @RequestMapping("/admin/page/systemSetting/icons")
    public String toAdminSystemSettingIcons(){
        return "admin/page/systemSetting/icons";
    }
    //三级联动模块
    @RequestMapping("/admin/page/doc/addressDoc")
    public String toAdminDocAddressDoc(){
        return "/admin/page/doc/addressDoc";
    }
    //bodyTab模块
    @RequestMapping("/admin/page/doc/bodyTabDoc")
    public String toAdminDocBodyTabDoc(){
        return "admin/page/doc/bodyTabDoc";
    }
    //三级菜单
    @RequestMapping("/admin/page/doc/navDoc")
    public String toAdminDocNavDoc(){
        return "admin/page/doc/navDoc";
    }
}
