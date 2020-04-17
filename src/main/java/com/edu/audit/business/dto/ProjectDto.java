package com.edu.audit.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("工程前端对应映射")
public class ProjectDto {
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("工程名")
    private String projectName;
    @ApiModelProperty("工程实施用户id")
    private String userId;
    @ApiModelProperty("工程实施用户名")
    private String username;
    @ApiModelProperty("工程阶段（1-立项 2-立项审核中 3-预算 4-预算审核中 5-拨付 6-拨付审核中 7-结算 8-结算审核中 9-实施中 10-实施结束）")
    private Integer stage;
    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT-5",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty("创建人")
    private String createBy;
    @ApiModelProperty("更新时间")
    @JsonFormat(timezone = "GMT-5",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @ApiModelProperty("更新人")
    private String updateBy;
    @ApiModelProperty("工程描述")
    private String description;
}
