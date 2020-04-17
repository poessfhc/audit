package com.edu.audit.authority.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("用户")
public class SysUser {

    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("用户名称")
    private String username;
    @ApiModelProperty("用户邮箱")
    private String email;
    @ApiModelProperty("手机号码")
    private String phonenumber;
    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private String sex;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("盐加密")
    private String salt;
    @ApiModelProperty("删除标志")
    private String deleteFlag;
    @ApiModelProperty("创建者")
    private String createBy;
    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT-5",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty("更新者")
    private String updateBy;
    @ApiModelProperty("更新时间")
    @JsonFormat(timezone = "GMT-5",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @ApiModelProperty("验证码")
    private String code;
}