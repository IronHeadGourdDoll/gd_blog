package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="blog_comment_liked")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogCommentLiked implements Serializable {
    @Id
    public long comment_id;
    @Id
    public String username;
}
