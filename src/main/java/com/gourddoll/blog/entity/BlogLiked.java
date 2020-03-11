package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="blog_liked")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogLiked implements Serializable {

    private static final long serialVersionUID = 4967004621141911451L;

    @Id
    public long blogId;
    @Id
    public String username;
}
