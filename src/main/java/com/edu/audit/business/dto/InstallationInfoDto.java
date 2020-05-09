package com.edu.audit.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: InstallationInfoDto
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/8 12:16
 * @Version: v1.0
 */
@Data
@ApiModel("工程设施完成情况")
public class InstallationInfoDto {
    @ApiModelProperty("设施名字")
    private String installationName;
    @ApiModelProperty("设施总数")
    private Integer installationNum;
    @ApiModelProperty("是否完成 1-完成 0-未完成")
    private Integer flag;
}
