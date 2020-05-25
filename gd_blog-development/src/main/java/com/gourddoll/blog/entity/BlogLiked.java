package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="blog_liked")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogLiked implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long blogId;
    public String username;
    public Long status;
    public String createtime;

}