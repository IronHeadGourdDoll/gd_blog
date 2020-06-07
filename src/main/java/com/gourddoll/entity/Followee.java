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
 * 关注博主表
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
@TableName("followee")
@ApiModel(value="Followee对象", description="关注博主表")
public class Followee extends Model<Followee> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "我关注的人的id")
    @TableId("followee_id")
    private Integer followeeId;

    @ApiModelProperty(value = "我的id(我是粉丝)")
    @TableField("fan_id")
    private Integer fanId;


    public static final String FOLLOWEE_ID = "followee_id";

    public static final String FAN_ID = "fan_id";

    @Override
    protected Serializable pkVal() {
        return this.followeeId;
    }

}
