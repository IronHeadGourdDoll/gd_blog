package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="link")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String username;
    public String linkedUsername;
    public String url;
    public String summary;
    public String img;
    public Long status;
    public Long weight;
    public Long display;
    public String email;
}
