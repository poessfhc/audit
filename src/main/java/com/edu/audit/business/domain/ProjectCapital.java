package com.edu.audit.business.domain;

import lombok.Data;

@Data
public class ProjectCapital {
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
}