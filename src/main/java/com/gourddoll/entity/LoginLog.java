package com.gourddoll.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 登录日志表，用来度量网站访问量（访问留言板等都算）。同一ip一段时间访问无论是否登录都会插入一条记录，未登录status=0，登录为1
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
@TableName("login_log")
@ApiModel(value="LoginLog对象", description="登录日志表，用来度量网站访问量（访问留言板等都算）。同一ip一段时间访问无论是否登录都会插入一条记录，未登录status=0，登录为1")
public class LoginLog extends Model<LoginLog> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("exit_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String exitTime;

    @TableField("spu_id")
    private Integer spuId;


    public static final String ID = "id";

    public static final String EXIT_TIME = "exit_time";

    public static final String SPU_ID = "spu_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
