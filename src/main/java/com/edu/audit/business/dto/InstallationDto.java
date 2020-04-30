package com.edu.audit.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName: InstallationDto
 * @Description: 工程设施返回类
 * @Author: Vince
 * @Date: 2020/2/29 18:19
 * @Version: v1.0
 */
@Data
@ApiModel("工程设施返回类")
public class InstallationDto {
    @ApiModelProperty("主键")
    private Integer installationId;
    @ApiModelProperty("设施名字")
    private String installationName;
    @ApiModelProperty("设施价格（元/平方米）")
    private BigDecimal price;
    @ApiModelProperty("设施描述")
    private String description;
}
