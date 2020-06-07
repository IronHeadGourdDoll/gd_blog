package com.gourddoll.controller;


import com.gourddoll.constant.StatusCode;
import com.gourddoll.entity.Blog;
import com.gourddoll.entity.Category;
import com.gourddoll.service.BlogService;
import com.gourddoll.service.CategoryService;
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
 * 分类表 前端控制器
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public Map<String,Object> getAll(){
        Map<String, Object> map = new HashMap<>();
        List<Category> categories= categoryService.list();
        map.put("categories",categories);
        map.put("result",new Result(true, StatusCode.OK,"查找成功"));
        return map;
    }

}
