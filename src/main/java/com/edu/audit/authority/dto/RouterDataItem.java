package com.edu.audit.authority.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: RouterDataItem
 * @Description: 路由数据
 * @Author: Vince
 * @Date: 2020/4/11 15:21
 * @Version: v1.0
 */
@Data
public class RouterDataItem {
    @ApiModelProperty("url")
    private String path;
    @ApiModelProperty("组件名")
    private String component;
    @ApiModelProperty("名字")
    private String name;
}
