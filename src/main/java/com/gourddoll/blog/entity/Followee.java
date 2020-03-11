package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="followee")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Followee implements Serializable {
    @Id
    public String followeeId;
    @Id
    public String fanId;
}
