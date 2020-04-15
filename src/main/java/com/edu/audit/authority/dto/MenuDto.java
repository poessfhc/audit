package com.edu.audit.authority.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: MenuDto
 * @Description: 显示菜单返回集
 * @Author: Vince
 * @Date: 2020/3/1 13:16
 * @Version: v1.0
 */
@Data
@ApiModel("显示菜单返回集")
public class MenuDto {
    @ApiModelProperty("id")
    private String menuId;
    @ApiModelProperty("标题")
    private String icon;
    @ApiModelProperty("索引")
    private String index;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("子菜单")
    private List<SubMenu> subs;
}
