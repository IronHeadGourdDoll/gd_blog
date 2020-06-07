package com.gourddoll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

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
 * 博客表
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
@TableName("blog")
@ApiModel(value="Blog对象", description="博客表")
public class Blog extends Model<Blog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("title")
    private String title;

    @TableField("author")
    private String author;

    @ApiModelProperty(value = "博客简介")
    @TableField("summary")
    private String summary;

    @TableField("content")
    private String content;

    @TableField("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

    @TableField("update_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateTime;

    @ApiModelProperty(value = "是否推荐，0不推荐，1推荐")
    @TableField("commend")
    private Integer commend;

    @ApiModelProperty(value = "博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱")
    @TableField("status")
    private Integer status;

    @TableField("header_img")
    private String headerImg;

    @TableField("category_name")
    private String categoryName;

    @TableField("read_times")
    private Integer readTimes;

    @TableField("liked_times")
    private Integer likedTimes;

    @TableField("disliked_times")
    private Integer dislikedTimes;

    @TableField("comment_times")
    private Integer commentTimes;

    @TableField("grade")
    private Integer grade;

    @TableField(exist = false)
    private List<Tag> tags;

    public static final String ID = "id";

    public static final String TITLE = "title";

    public static final String AUTHOR = "author";

    public static final String SUMMARY = "summary";

    public static final String CONTENT = "content";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String COMMEND = "commend";

    public static final String STATUS = "status";

    public static final String HEADER_IMG = "header_img";

    public static final String CATEGORY_NAME = "category_name";

    public static final String READ_TIMES = "read_times";

    public static final String LIKED_TIMES = "liked_times";

    public static final String DISLIKED_TIMES = "disliked_times";

    public static final String COMMENT_TIMES = "comment_times";

    public static final String GRADE = "grade";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
