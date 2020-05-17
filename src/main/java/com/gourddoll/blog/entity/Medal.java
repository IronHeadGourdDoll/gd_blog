package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="medal")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String medalName;
    public String img;
    public String description;
}
