package com.edu.audit.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("设施")
public class Installation {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("设施名字")
    private String installationName;
    @ApiModelProperty("设施价格（元/平方米）")
    private BigDecimal price;
    @ApiModelProperty("设施描述")
    private String description;
}