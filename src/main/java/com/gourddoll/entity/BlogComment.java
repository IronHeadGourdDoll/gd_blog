package com.gourddoll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 博客评论表
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("blog_comment")
@ApiModel(value="BlogComment对象", description="博客评论表")
public class BlogComment extends Model<BlogComment> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "每一条评论都有一个id，其他都是回复blog_comment_id")
    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "评论的博客")
    @TableField("blog_id")
    private Integer blogId;

    @TableField("content")
    private String content;

    @ApiModelProperty(value = "0直接评论blog_id的，其他都是")
    @TableField("parent")
    private String parent;

    @TableField("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

    @ApiModelProperty(value = "是谁评论的")
    @TableField("commentator")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String commentator;


    public static final String ID = "id";

    public static final String BLOG_ID = "blog_id";

    public static final String CONTENT = "content";

    public static final String PARENT = "parent";

    public static final String CREATE_TIME = "create_time";

    public static final String COMMENTATOR = "commentator";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
