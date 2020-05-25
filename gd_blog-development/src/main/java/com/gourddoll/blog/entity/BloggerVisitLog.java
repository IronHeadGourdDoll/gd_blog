package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="bolgger_visit_log")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloggerVisitLog  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String ipAddr;
    public Long location;
    public String browser;
    public String os;
    public String visitTime;
    public String visitorName;
    public String username;

}
