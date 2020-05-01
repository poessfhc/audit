package com.edu.audit.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@ApiModel("工程审核记录")
@NoArgsConstructor
public class ProjectAudit {
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("主键")
    private String auditName;
    @ApiModelProperty("主键")
    private Integer auditType;
    @ApiModelProperty("主键")
    private Byte auditResult;
    @ApiModelProperty("主键")
    @JsonFormat(timezone = "GMT-5",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date auditTime;
    @ApiModelProperty("工程id")
    private String projectId;
    @ApiModelProperty("审核人员")
    private String auditUser;

    public ProjectAudit(String id, String auditName, Integer auditType, Byte auditResult, String projectId, String auditUser) {
        this.id = id;
        this.auditName = auditName;
        this.auditType = auditType;
        this.auditResult = auditResult;
        this.projectId = projectId;
        this.auditUser = auditUser;
    }
}