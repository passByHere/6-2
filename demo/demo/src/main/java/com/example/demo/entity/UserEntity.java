package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("user")
public class UserEntity {
    @ApiModelProperty(value = "主键")
    @TableId
    private Long id;

    @ApiModelProperty(value = "姓名")
    @TableField("username")
    private String userName;

    @ApiModelProperty(value = "年龄")
    private Integer age;

}
