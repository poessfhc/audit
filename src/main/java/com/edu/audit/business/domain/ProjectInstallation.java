package com.edu.audit.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("工程所需要设施以及数量")
public class ProjectInstallation {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("工程id")
    private String projectId;
    @ApiModelProperty("设施id")
    private String installationId;
    @ApiModelProperty("设施数量")
    private Integer installationNum;
}