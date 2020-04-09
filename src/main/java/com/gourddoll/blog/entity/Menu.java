package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="menu")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    private static final long serialVersionUID = 4961236908141911451L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long menuId;
    public String menuName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_menu", joinColumns = {@JoinColumn(name = "menu_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roleList;

}
