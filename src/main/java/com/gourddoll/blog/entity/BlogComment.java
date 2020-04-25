package com.gourddoll.blog.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="blog_comment")
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long commentId;
}
