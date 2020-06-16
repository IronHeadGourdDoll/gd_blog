package com.gourddoll.blog.service;

import com.gourddoll.blog.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();
    Tag findTagById(Long id);

    Tag findTagByTagName(String tagName);
}
