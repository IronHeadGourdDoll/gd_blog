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
@TableName("link")
@ApiModel(value="Link对象", description="")
public class Link extends Model<Link> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("linked_username")
    private String linkedUsername;

    @TableField("url")
    private String url;

    @TableField("summary")
    private String summary;

    @TableField("img")
    private String img;

    @ApiModelProperty(value = "1表示审核通过,0表示未审核")
    @TableField("status")
    private Integer status;

    @TableField("weight")
    private Integer weight;

    @TableField("display")
    private Integer display;

    @TableField("email")
    private String email;


    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String LINKED_USERNAME = "linked_username";

    public static final String URL = "url";

    public static final String SUMMARY = "summary";

    public static final String IMG = "img";

    public static final String STATUS = "status";

    public static final String WEIGHT = "weight";

    public static final String DISPLAY = "display";

    public static final String EMAIL = "email";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
