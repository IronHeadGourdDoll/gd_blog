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
 * 博客评论点赞表
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
@TableName("blog_comment_liked")
@ApiModel(value="BlogCommentLiked对象", description="博客评论点赞表")
public class BlogCommentLiked extends Model<BlogCommentLiked> {

    private static final long serialVersionUID = 1L;

    @TableId("comment_id")
    private Integer commentId;

    @ApiModelProperty(value = "对评论 点赞或点踩 的人")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "0代表踩，1代表赞")
    @TableField("status")
    private Integer status;

    @TableField("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;


    public static final String COMMENT_ID = "comment_id";

    public static final String USERNAME = "username";

    public static final String STATUS = "status";

    public static final String CREATE_TIME = "create_time";

    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

}
