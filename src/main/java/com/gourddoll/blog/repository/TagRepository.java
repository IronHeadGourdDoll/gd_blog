package com.gourddoll.blog.repository;

import com.gourddoll.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long>, JpaSpecificationExecutor<Tag> {

    //所有排序在impl层手动调整
    List<Tag> findAll();//查找所有标签

    Tag findAllById(Long id);//通过id查找标签


    Tag findByTagName(String tagName);
}
