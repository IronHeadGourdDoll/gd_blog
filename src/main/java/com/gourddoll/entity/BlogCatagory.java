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
 * 博客分类表
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
@TableName("blog_catagory")
@ApiModel(value="BlogCatagory对象", description="博客分类表")
public class BlogCatagory extends Model<BlogCatagory> {

    private static final long serialVersionUID = 1L;

    @TableId("blog_id")
    private Integer blogId;

    @TableField("catagory_id")
    private Integer catagoryId;


    public static final String BLOG_ID = "blog_id";

    public static final String CATAGORY_ID = "catagory_id";

    @Override
    protected Serializable pkVal() {
        return this.blogId;
    }

}
