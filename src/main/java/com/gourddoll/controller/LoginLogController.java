package com.gourddoll.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 登录日志表，用来度量网站访问量（访问留言板等都算）。同一ip一段时间访问无论是否登录都会插入一条记录，未登录status=0，登录为1 前端控制器
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@RestController
@CrossOrigin
@RequestMapping("/login-log")
public class LoginLogController {

}
