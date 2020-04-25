package com.gourddoll.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="blog")
@Entity
@DynamicInsert
@DynamicUpdate
@Data
public class Blog implements Serializable {
    private static final long serialVersionUID = 4967006908141911451L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//这样的话，save(xxx)后xxx就已经更新为已经保存的实体了,添加的xxx就有id了
    public Long blogId;
    public String title;
    public String author;
    public String summary;
    @Lob
    @Column(columnDefinition = "TEXT")
    public String content;
    public String createTime;
    public String updateTime;
    public Integer commend;
    public Integer status;
    public String headerImg;
    public String categoryName;
    public int readTimes;
    public int likedTimes;
    public int dislikedTimes;
    public int commentTimes;
    public int grade;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH})//急加载，级联删除
    @JoinTable(
            name = "blog_tag",//连接表
            joinColumns = {@JoinColumn(name = "blog_id")},//所有方，通过name连接，表字段
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}//非所有方，把name加进来成为list，再根据此tag_id查找tag_name
    )
    public List<Tag> tagList;//????为什么是taglist,一直为null，生成一张中间表

    @Transient
    private List<String> tagNameList;
}
