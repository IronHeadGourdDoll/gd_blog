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
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long messageId;
    //博主username
    public String username;
    //回复的留言id，为0自己就是根
    public String messageParent;
    //留言者的username
    public String messagePeople;
    @Lob
    @Column(columnDefinition = "TEXT")
    public String content;
    public String createTime;

}
