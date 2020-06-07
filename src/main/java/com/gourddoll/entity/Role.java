package com.gourddoll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * <p>
 * 角色表
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
@TableName("role")
@ApiModel(value="Role对象", description="角色表")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("is_enable")
    private Integer isEnable;

    @TableField("role_name")
    private String roleName;

    @TableField("description")
    private String description;

    @TableField(exist = false)
    List<User> users;

    @TableField(exist = false)
    List<Menu> menus;

    public static final String ID = "id";

    public static final String IS_ENABLE = "is_enable";

    public static final String ROLE_NAME = "role_name";

    public static final String DESCRIPTION = "description";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
