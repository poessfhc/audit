package com.edu.audit.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("统计预算数据的返回集")
public class InstallationCountDto {
    @ApiModelProperty("工程id")
    private String id;
    @ApiModelProperty("工程名")
    private  String projectName;
    @ApiModelProperty("设施预算列表")
    private List<SingleInstallation> installations;
    @ApiModelProperty("总价")
    private BigDecimal totalPrice;
}
