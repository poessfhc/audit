package com.edu.audit.authority.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("菜单")
public class SysMenu {
    @ApiModelProperty("菜单ID")
    private String menuId;
    @ApiModelProperty("名称")
    private String menuName;
    @ApiModelProperty("父菜单ID")
    private String parentId;
    @ApiModelProperty("请求地址")
    private String url;
    @ApiModelProperty("菜单类型（M目录 C菜单 F按钮）")
    private String menuType;
    @ApiModelProperty("权限标识")
    private String perms;
    @ApiModelProperty("创建者")
    private String createBy;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新者")
    private String updateBy;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}