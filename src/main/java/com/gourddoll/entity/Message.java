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
@TableName("message")
@ApiModel(value="Message对象", description="")
public class Message extends Model<Message> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "博主")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "0代表留的言，1代表留言的 留言，按时间降序")
    @TableField("parent")
    private String parent;

    @ApiModelProperty(value = "留言者的用户名")
    @TableField("message_people")
    private String messagePeople;

    @TableField("content")
    private String content;

    @TableField("create_time")
    private String createTime;


    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String PARENT = "parent";

    public static final String MESSAGE_PEOPLE = "message_people";

    public static final String CONTENT = "content";

    public static final String CREATE_TIME = "create_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
