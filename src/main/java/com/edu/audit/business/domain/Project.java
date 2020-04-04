package com.edu.audit.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("工程")
public class Project {
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("工程名")
    private String projectName;
    @ApiModelProperty("工程实施用户id")
    private String userId;
    @ApiModelProperty("工程阶段（1-立项 2-立项审核中 3-预算 4-预算审核中 5-拨付 6-拨付审核中 7-结算 8-结算审核中 9-实施中 10-实施结束）")
    private Integer stage;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("创建人")
    private String createBy;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("更新人")
    private String updateBy;
    @ApiModelProperty("工程描述")
    private String description;
}