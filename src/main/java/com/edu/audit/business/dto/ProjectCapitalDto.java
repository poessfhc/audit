package com.edu.audit.business.dto;

import lombok.Data;

/**
 * @ClassName: ProjectCapitalDto
 * @Description: 预算详细（联表）
 * @Author: Vince
 * @Date: 2020/2/27 15:18
 * @Version: v1.0
 */
@Data
public class ProjectCapitalDto {
    /**
     * 主键
     */
    private String id;
    /**
     * 预算资金（元）
     */
    private Integer budget;
    /**
     * 实际资金（元）
     */
    private Integer actual;
    /**
     * 工程id
     */
    private String projectId;
    /**
     * 工程描述
     */
    private String description;
}
