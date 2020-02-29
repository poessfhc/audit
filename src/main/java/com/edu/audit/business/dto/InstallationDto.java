package com.edu.audit.business.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName: InstallationDto
 * @Description: 工程设施返回类
 * @Author: Vince
 * @Date: 2020/2/29 18:19
 * @Version: v1.0
 */
@Data
public class InstallationDto {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 设施名字
     */
    private String installationName;
    /**
     * 设施价格（元/平方米）
     */
    private BigDecimal price;
    /**
     * 设施描述
     */
    private String description;
}
