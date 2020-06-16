package com.gourddoll.blog.service.impl;

import com.gourddoll.blog.entity.Category;
import com.gourddoll.blog.repository.CategoryRepository;
import com.gourddoll.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
