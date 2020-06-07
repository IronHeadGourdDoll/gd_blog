package com.gourddoll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 用户的一些基本信息
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
@TableName("user")
@ApiModel(value="User对象", description="用户的一些基本信息")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "登录用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "昵称")
    @TableField("nickname")
    private String nickname;

    @TableField("pwd")
    private String pwd;

    @ApiModelProperty(value = "1='男'，0='女'")
    @TableField("sex")
    private String sex;

    @TableField("birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String birth;

    @TableField("address")
    private String address;

    @TableField("education")
    private String education;

    @TableField("career")
    private String career;

    @TableField("self_introduction")
    private String selfIntroduction;

    @TableField("dream")
    private String dream;

    @TableField("technology")
    private String technology;

    @TableField("project")
    private String project;

    @TableField("hobby")
    private String hobby;

    @TableField("join_date")
    private String joinDate;

    @TableField("blog_num")
    private Integer blogNum;

    @TableField("commend_times")
    private Integer commendTimes;

    @TableField("disliked_times")
    private Integer dislikedTimes;

    @TableField("fans")
    private Integer fans;

    @TableField("followers")
    private Integer followers;

    @TableField("grade")
    private Integer grade;

    @TableField("liked_times")
    private Integer likedTimes;

    @ApiModelProperty(value = "一段时间内博客或留言板每被浏览一次退出时+1")
    @TableField("pageviews")
    private Integer pageviews;

    @TableField("visitors")
    private Integer visitors;

    @TableField(exist = false)
    List<Role> roles;

    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String NICKNAME = "nickname";

    public static final String PWD = "pwd";

    public static final String SEX = "sex";

    public static final String BIRTH = "birth";

    public static final String ADDRESS = "address";

    public static final String EDUCATION = "education";

    public static final String CAREER = "career";

    public static final String SELF_INTRODUCTION = "self_introduction";

    public static final String DREAM = "dream";

    public static final String TECHNOLOGY = "technology";

    public static final String PROJECT = "project";

    public static final String HOBBY = "hobby";

    public static final String JOIN_DATE = "join_date";

    public static final String BLOG_NUM = "blog_num";

    public static final String COMMEND_TIMES = "commend_times";

    public static final String DISLIKED_TIMES = "disliked_times";

    public static final String FANS = "fans";

    public static final String FOLLOWERS = "followers";

    public static final String GRADE = "grade";

    public static final String LIKED_TIMES = "liked_times";

    public static final String PAGEVIEWS = "pageviews";

    public static final String VISITORS = "visitors";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
