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
 * 访问博客会被记录到blog_visit_log，blogger_visit_log，login_log三个表
访问留言板，关于我等会被记录到login_log，blog_visit_log
操作会被记录到login_log，operate_log

相同ip一段时间内（2小时）重复访问只会记录一次
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
@TableName("log_spu")
@ApiModel(value="LogSpu对象", description="访问博客会被记录到blog_visit_log，blogger_visit_log，login_log三个表"+
"访问留言板，关于我等会被记录到login_log，blog_visit_log"+
"操作会被记录到login_log，operate_log"+
"相同ip一段时间内（2小时）重复访问只会记录一次")
public class LogSpu extends Model<LogSpu> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("ip_addr")
    private Integer ipAddr;

    @TableField("location")
    private String location;

    @TableField("browser")
    private String browser;

    @TableField("os")
    private String os;

    @TableField("time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String time;

    @ApiModelProperty(value = "操作者的用户名")
    @TableField("username")
    private String username;

    @TableField("result_json")
    private String resultJson;


    public static final String ID = "id";

    public static final String IP_ADDR = "ip_addr";

    public static final String LOCATION = "location";

    public static final String BROWSER = "browser";

    public static final String OS = "os";

    public static final String TIME = "time";

    public static final String USERNAME = "username";

    public static final String RESULT_JSON = "result_json";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
