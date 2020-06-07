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
 * 徽章表
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
@TableName("medal")
@ApiModel(value="Medal对象", description="徽章表")
public class Medal extends Model<Medal> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("medal_name")
    private String medalName;

    @ApiModelProperty(value = "勋章图片")
    @TableField("img")
    private String img;

    @ApiModelProperty(value = "勋章描述")
    @TableField("description")
    private String description;


    public static final String ID = "id";

    public static final String MEDAL_NAME = "medal_name";

    public static final String IMG = "img";

    public static final String DESCRIPTION = "description";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
