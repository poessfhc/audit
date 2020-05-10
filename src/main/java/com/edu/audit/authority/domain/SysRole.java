package com.edu.audit.authority.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("角色")
public class SysRole {
    @ApiModelProperty("角色ID")
    private String roleId;
    @ApiModelProperty("角色名称")
    private String roleName;
    @ApiModelProperty("角色权限字符串")
    private String remark;
    @ApiModelProperty("角色状态（0正常 1停用）")
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
}