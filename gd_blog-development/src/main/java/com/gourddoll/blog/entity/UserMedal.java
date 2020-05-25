package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="user_medal")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMedal implements Serializable {
    @Id
    public String username;
    @Id
    @Column(name = "medal_id")
    public Long medalId;
}
