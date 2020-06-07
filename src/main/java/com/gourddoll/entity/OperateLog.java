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
 * 操作日志，增删改都会记录
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
@TableName("operate_log")
@ApiModel(value="OperateLog对象", description="操作日志，增删改都会记录")
public class OperateLog extends Model<OperateLog> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @ApiModelProperty(value = "请求方式（get/post/put/）")
    @TableField("request_method")
    private String requestMethod;

    @TableField("request_url")
    private String requestUrl;

    @ApiModelProperty(value = "请求参数")
    @TableField("param")
    private String param;

    @ApiModelProperty(value = "业务类型（0其它 1新增 2修改 3删除）")
    @TableField("business_type")
    private Integer businessType;


    public static final String ID = "id";

    public static final String REQUEST_METHOD = "request_method";

    public static final String REQUEST_URL = "request_url";

    public static final String PARAM = "param";

    public static final String BUSINESS_TYPE = "business_type";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
