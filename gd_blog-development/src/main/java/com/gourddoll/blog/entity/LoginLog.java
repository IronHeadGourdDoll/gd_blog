package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="login_log")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String ipAddr;
    public String location;
    public String browser;
    public String os;
    public String requestUrl;
    public String blogId;
    public String loginTime;
    public String username;
    public String exitTime;
}
