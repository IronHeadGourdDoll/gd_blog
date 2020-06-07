package com.gourddoll.controller;


import com.gourddoll.constant.StatusCode;
import com.gourddoll.entity.Blog;
import com.gourddoll.entity.Tag;
import com.gourddoll.service.BlogService;
import com.gourddoll.service.TagService;
import com.gourddoll.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@RestController
@CrossOrigin
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("")
    public Map<String,Object> getAll(){
        Map<String, Object> map = new HashMap<>();
        List<Tag> tags= tagService.list();
        map.put("tags",tags);
        map.put("result",new Result(true, StatusCode.OK,"查找成功"));
        return map;
    }

}
