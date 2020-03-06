package com.edu.audit.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("工程资金")
public class ProjectCapital {
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("预算资金（元）")
    private Integer budget;
    @ApiModelProperty("实际资金（元）")
    private Integer actual;
    @ApiModelProperty("工程id")
    private String projectId;
}