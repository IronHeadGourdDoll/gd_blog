package com.gourddoll.blog.service.impl;

import com.gourddoll.blog.entity.Tag;
import com.gourddoll.blog.repository.TagRepository;
import com.gourddoll.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findTagById(Long id) {
        return tagRepository.findAllById(id);
    }

    @Override
    public Tag findTagByTagName(String tagName) {
        return tagRepository.findByTagName(tagName);
    }
}
