package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name="blog")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {
    private static final long serialVersionUID = 4967006908141911451L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long blogId;
    public String title;
    public String author;
    public String summary;
    @Lob
    @Column(columnDefinition = "TEXT")
    public String content;
    @Temporal(TemporalType.DATE)
    public Date createTime;
    @Temporal(TemporalType.DATE)
    public Date updateTime;
    public int commend;
    public int status;
    public String headerImg;
    public int readTimes;
    public int likedTimes;
    public int dislikedTimes;
    public int commentTimes;
    public int grade;

    @ManyToMany
    @JoinTable(
            name = "blog_tag",//连接表
            joinColumns = {@JoinColumn(name = "blog_id")},//所有方
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}//非所有方
            )
    private List<Tag> tagList;

    @OneToOne
    @JoinColumn(name="category_id")
    public Category category;

}
