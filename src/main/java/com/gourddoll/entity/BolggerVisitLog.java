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
 * 博主浏览记录表（我看过谁（博客留言板等都会被记录））=》求和-网站浏览记录表
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
@TableName("bolgger_visit_log")
@ApiModel(value="BolggerVisitLog对象", description="博主浏览记录表（我看过谁（博客留言板等都会被记录））=》求和-网站浏览记录表")
public class BolggerVisitLog extends Model<BolggerVisitLog> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "被访问的用户名")
    @TableField("visited_name")
    private String visitedName;


    public static final String ID = "id";

    public static final String VISITED_NAME = "visited_name";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
