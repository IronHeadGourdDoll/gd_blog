package com.gourddoll.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Table(name="message")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateLog  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String ipAddr;
    public Long location;
    public String browser;
    public String os;
    public String requestMethod;
    public String requestUrl;
    public String param;
    public String operateTime;
    public String visitorName;
    public String username;
    public String businessType;
    public String jsonResult;
}
