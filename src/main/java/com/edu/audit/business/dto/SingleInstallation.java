package com.edu.audit.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("单个设施数据")
public class SingleInstallation {
    @ApiModelProperty("设施名")
    private String installationName;
    @ApiModelProperty("设施单价")
    private BigDecimal price;
    @ApiModelProperty("设施总数")
    private Integer installationNum;
    @ApiModelProperty("设施总价")
    private BigDecimal total;
}
