package com.gourddoll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * <p>
 * 博客浏览记录表
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
@TableName("blog_visit_log")
@ApiModel(value="BlogVisitLog对象", description="博客浏览记录表")
public class BlogVisitLog extends Model<BlogVisitLog> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "访问博客的id")
    @TableField("blog_id")
    private Integer blogId;

    @ApiModelProperty(value = "访客")
    @TableField("visitor_name")
    private String visitorName;


    public static final String ID = "id";

    public static final String BLOG_ID = "blog_id";

    public static final String VISITOR_NAME = "visitor_name";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
