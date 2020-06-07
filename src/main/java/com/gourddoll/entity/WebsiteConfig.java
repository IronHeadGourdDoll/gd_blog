package com.gourddoll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 
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
@TableName("website_config")
@ApiModel(value="WebsiteConfig对象", description="")
public class WebsiteConfig extends Model<WebsiteConfig> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("author_name")
    private String authorName;

    @TableField("blog_name")
    private String blogName;

    @TableField("domain_name")
    private String domainName;

    @TableField("email")
    private String email;

    @ApiModelProperty(value = "备案号")
    @TableField("record_number")
    private String recordNumber;

    @ApiModelProperty(value = "网站风格")
    @TableField("theme")
    private String theme;


    public static final String ID = "id";

    public static final String AUTHOR_NAME = "author_name";

    public static final String BLOG_NAME = "blog_name";

    public static final String DOMAIN_NAME = "domain_name";

    public static final String EMAIL = "email";

    public static final String RECORD_NUMBER = "record_number";

    public static final String THEME = "theme";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
