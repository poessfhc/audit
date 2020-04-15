package com.edu.audit.authority.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: SubMenu
 * @Description: 子菜单
 * @Author: Vince
 * @Date: 2020/4/11 14:55
 * @Version: v1.0
 */
@Data
public class SubMenu {
    @ApiModelProperty("url")
    private String index;
    @ApiModelProperty("名字")
    private String title;
}
