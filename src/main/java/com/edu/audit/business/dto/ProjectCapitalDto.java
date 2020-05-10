package com.edu.audit.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: ProjectCapitalDto
 * @Description: 预算详细（联表）
 * @Author: Vince
 * @Date: 2020/2/27 15:18
 * @Version: v1.0
 */
@Data
@ApiModel("预算详细（联表）")
public class ProjectCapitalDto {
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("预算资金（元）")
    private Integer budget;
    @ApiModelProperty("拨付资金（元）")
    private Integer actual;
    @ApiModelProperty("最终资金（元）")
    private Integer finalAmount;
    @ApiModelProperty("工程id")
    private String projectId;
    @ApiModelProperty("工程描述")
    private String description;
}
