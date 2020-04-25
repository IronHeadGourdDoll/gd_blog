package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userId;
    public String username;
    public String nickname;
    public String pwd;
    public Integer sex;
    public String birth;
    public String address;
    public String education;
    public String career;
    public String selfIntroduction;
    public String dream;
    public String technology;
    public String project;
    public String hobby;
    public String joinDate;
    public int followers;
    public int fans;
    public int visitors;
    public int pageviews;
    public int likedTimes;
    public int dislikedTimes;
    public int grade;
    public int blogNum;
    public int commendTimes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roleList;
}
