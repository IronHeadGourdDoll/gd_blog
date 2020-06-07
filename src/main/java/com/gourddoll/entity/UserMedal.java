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
@TableName("user_medal")
@ApiModel(value="UserMedal对象", description="")
public class UserMedal extends Model<UserMedal> {

    private static final long serialVersionUID = 1L;

    @TableId("username")
    private String username;

    @TableField("medal_id")
    private Integer medalId;


    public static final String USERNAME = "username";

    public static final String MEDAL_ID = "medal_id";

    @Override
    protected Serializable pkVal() {
        return this.username;
    }

}
