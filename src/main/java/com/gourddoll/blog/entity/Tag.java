package com.gourddoll.blog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tag")
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer tagId;
    public String tagName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "blog_tag",//连接表
            joinColumns = {@JoinColumn(name = "tag_id")},//所有方，通过name连接，表字段
            inverseJoinColumns = {@JoinColumn(name = "blog_id")}//非所有方，把name加进来成为list，再根据此tag_id查找tag_name
    )
    List<Blog> blogList;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
