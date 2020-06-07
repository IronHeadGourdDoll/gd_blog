package com.gourddoll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * 博客标签表
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
@TableName("blog_tag")
@ApiModel(value="BlogTag对象", description="博客标签表")
public class BlogTag extends Model<BlogTag> {

    private static final long serialVersionUID = 1L;

    @TableField("tag_id")
    private Integer tagId;

    @TableField("blog_id")
    private Integer blogId;


    public static final String TAG_ID = "tag_id";

    public static final String BLOG_ID = "blog_id";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
