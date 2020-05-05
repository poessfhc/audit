package com.edu.audit.authority.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("用户表单")
public class UserVo {
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
    @ApiModelProperty("验证码")
    private String code;
}
